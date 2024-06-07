package com.jue.java.backup;

import com.jue.java.backup.constant.TableField;
import com.jue.java.backup.constant.TableName;
import com.jue.java.backup.entity.DataBase;
import org.python.google.common.collect.Lists;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 简单的工具类
 * 分为列表查询、更新、删除操作
 *
 * @author JUE
 */
public class JdbcSimpleUtils<T extends DataBase> {

    // "jdbc:sqlite:test.db"
    private String url;
    private String tableName;

    private Class<T> tClass;
    private List<String> tableColumns;
    private Map<String, Field> columnMap;

    private JdbcSimpleUtils() {
    }

    private JdbcSimpleUtils(String url, Class<T> tClass) {
        this.url = url;
        this.tClass = tClass;
    }

    private void init(Class<T> tClass) {
        tableName = tClass.getAnnotation(TableName.class).value();
        tableColumns = new ArrayList<>();
        columnMap = new HashMap<>();
        ReflectionUtils.doWithFields(tClass, f -> {
            f.setAccessible(true);
            TableField tableField = f.getAnnotation(TableField.class);
            if (tableField != null) {
                tableColumns.add(tableField.value());
                columnMap.put(tableField.value(), f);
            }
        });
    }

    public static <T extends DataBase> JdbcSimpleUtils<T> instance(String url, Class<T> tClass) {
        JdbcSimpleUtils<T> res = new JdbcSimpleUtils<>(url, tClass);
        res.init(tClass);
        if (!res.exist()) {
            res.create();
        }
        return res;
    }

    public List<T> list() throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return executeQuery("SELECT * FROM " + tableName, res -> {
            List<T> result = new ArrayList<>();
            try {
                while (res.next()) {
                    T data = tClass.getDeclaredConstructor().newInstance();
                    String id = res.getString("ID");
                    data.setId(id);
                    for (Map.Entry<String, Field> entry : columnMap.entrySet()) {
                        ReflectionUtils.setField(entry.getValue(), data, res.getString(entry.getKey()));
                    }
                    result.add(data);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        });
    }

    public void insertOrUpdate(List<T> list) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        if (list == null || list.size() == 0) {
            return;
        }
        Map<String, T> map = list().stream().collect(Collectors.toMap(DataBase::getId, Function.identity()));
        List<String> sqlList = new ArrayList<>();
        for (T data : list) {
            if (map.containsKey(data.getId())) {
                sqlList.add(updateByIdSql(data));
            } else {
                sqlList.add(insertSql(data));
            }
        }
        executeUpdate(sqlList);
    }

    public String insertSql(T data) {
        List<String> columns = new ArrayList<>();
        List<String> values = new ArrayList<>();
        columns.add("ID");
        values.add("'" + data.getId() + "'");
        for (Map.Entry<String, Field> entry : columnMap.entrySet()) {
            columns.add(entry.getKey());
            String value = (String) ReflectionUtils.getField(entry.getValue(), data);
            if (value != null) {
                value = value.replaceAll("'", "''");
            }
            values.add("'" + value + "'");
        }
        return String.format("INSERT INTO %s(%s) VALUES(%s);", tableName, String.join(",", columns), String.join(",", values));
    }

    public void insert(List<T> list) throws SQLException {
        if (list == null || list.size() == 0) {
            return;
        }
        executeUpdate(list.stream().map(this::insertSql).collect(Collectors.toList()));
    }

    public String updateByIdSql(T data) {
        String id = data.getId();
        String set = columnMap.entrySet().stream()
                .map((entry) -> {
                    String value = (String) ReflectionUtils.getField(entry.getValue(), data);
                    if (value != null) {
                        value = value.replaceAll("'", "''");
                    }
                    return String.format("%s='%s'", entry.getKey(), value);
                })
                .collect(Collectors.joining(","));
        return String.format("UPDATE %s SET %s WHERE ID = '%s';", tableName, set, id);
    }

    public void updateById(List<T> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        executeUpdate(list.stream().map(this::updateByIdSql).collect(Collectors.toList()));
    }

    public void deleteByIds(List<String> ids) {
        executeUpdate(String.format("DELETE FROM %s WHERE ID IN (%s)", tableName, String.join("','", ids)));
    }

    public boolean exist() {
        Boolean find = executeQuery("SELECT COUNT(1) FROM " + tableName, res -> {
            try {
                return res.next();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        });
        return Boolean.TRUE.equals(find);
    }

    public void create() {
        String BEGIN = "CREATE TABLE %s (\n ID INT PRIMARY KEY NOT NULL,\n";
        String LINE = "%s TEXT";
        String END = ")";
        executeUpdate(String.format(BEGIN, tableName) + tableColumns.stream().map(f -> String.format(LINE, f)).collect(Collectors.joining(",\n")) + END);
    }

    public <R> R executeQuery(String sql, Function<ResultSet, R> function) {
        return execute((statement -> {
            try {
                ResultSet set = statement.executeQuery(sql);
                return function.apply(set);
            } catch (Exception e) {
                System.out.println("not find >>> " + e.getMessage());
                return null;
            }
        }));
    }

    public void executeUpdate(String sql) {
        executeUpdate(Lists.newArrayList(sql));
    }

    public void executeUpdate(List<String> sql) {
        execute((statement -> {
            for (String sqlItem : sql) {
                try {
                    statement.executeUpdate(sqlItem);
                } catch (Exception e) {
                    System.out.println(sqlItem);
                    e.printStackTrace();
                }
            }
            return null;
        }));
    }

    public <R> R execute(Function<Statement, R> fn) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection(url);
            stmt = c.createStatement();
            return fn == null ? null : fn.apply(stmt);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (c != null) {
                    c.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
