package com.jue.java.gitlab;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.python.google.common.io.CharStreams;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 统计周期时间内文件提交数量
 * 1. 命令行查看Git提交的代码量(命令出错) https://blog.csdn.net/weixin_47872288/article/details/137055082?spm=1001.2101.3001.6650.2&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EYuanLiJiHua%7EPosition-2-137055082-blog-133742268.235%5Ev43%5Epc_blog_bottom_relevance_base1&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EYuanLiJiHua%7EPosition-2-137055082-blog-133742268.235%5Ev43%5Epc_blog_bottom_relevance_base1&utm_relevant_index=5
 * 2. 通过gitlab远程统计git代码量 https://blog.csdn.net/wenwen513/article/details/95647364
 * 3. gitlab官方接口地址 https://docs.gitlab.com/ee/api/api_resources.html
 *
 * @author JUE
 */
@Slf4j
public class CountCommitFile {

    public static final String URL_PREFIX = "http://192.168.104.54/api/v4";
    public static final String PRIVATE_TOKEN = "q6SxqCd7zj9sCGNSfzyU";
    public static final boolean USE_STORE = false;
    public static final String START_DAY = "2024-06-26T00:00:00.000+08:00";
    public static final String END_DAY = "2024-09-13T00:00:00.000+08:00";

    public static void main(String[] args) {
        CountCommitFile countCommitFile = new CountCommitFile();
        countCommitFile.exec();
    }

    public void exec() {
        // 获取所有项目分支
        List<CommitProject> projects = projects();
        // 统计所有分支
        List<CommitInfo> all = new ArrayList<>();
        for (CommitProject p : projects) {
            all.addAll(commits(p));
        }

        EasyExcel.write("C:/Users/JUE/Desktop/" + (System.currentTimeMillis() / 1000) + ".xlsx", CommitInfo.class).sheet("sheet").doWrite(all);
    }

    private List<CommitProject> projects() {
        // https://docs.gitlab.com/ee/api/projects.html#list-all-projects
        String url = String.format("/projects?simple=true&membership=true&per_page=100&order_by=updated_at&updated_after=%s&updated_before=%s", START_DAY, END_DAY);
        return selectAllWithStore("projects", url, CommitProject.class);
    }

    Set<String> existCommitId = new HashSet<>();

    private List<CommitInfo> commits(CommitProject project) {
        String projectId = project.getId();
        // https://docs.gitlab.com/ee/api/commits.html
        String url = String.format("/projects/%s/repository/commits?with_stats=true&author=wangjueya&all=true&per_page=100&since=%s&until=%s", projectId, START_DAY, END_DAY);
        List<CommitInfo> infos = new ArrayList<>(); //selectAllWithStore(projectId, url, CommitInfo.class);

        // gbase8s
        String[] branch = new String[]{"develop", "master", "hw"};
        for (String b : branch) {
            List<CommitInfo> item = selectAllWithStore(projectId, url + "&ref_name=" + b, CommitInfo.class);
            for (CommitInfo i : item) {
                if (i.getParent_ids() != null && !i.getParent_ids().isEmpty() && !existCommitId.contains(i.getId())) {
                    i.setBranch(b);
                    infos.add(i);
                    existCommitId.add(i.getId());
                }
            }
        }

        return infos.stream()
                .filter(e -> "wangjueya".equals(e.getAuthor_name()))
                .filter(e -> !e.getTitle().startsWith("Merge branch"))
                .filter(e -> !e.getTitle().startsWith("Merge remote-tracking"))
                /*
                .map(e -> {
                    CommitInfo res = stats(projectId, e.getId());
                    String group = project.getPath_with_namespace().replaceAll("/" + project.getName(), "");
                    res.setBranch(e.getBranch());
                    res.setProj(group);
                    res.setModule(project.getName());
                    return res;
                })
                 */
                .peek(e -> {
                    String group = project.getPath_with_namespace().replaceAll("/" + project.getName(), "");
                    e.setBranch(e.getBranch());
                    e.setProj(group);
                    e.setModule(project.getName());
                    e.setFileCount(changeFile(projectId, e.getId()));
                })
                .collect(Collectors.toList());
    }

    private Integer changeFile(String projectId, String commitId) {
        // https://docs.gitlab.com/ee/api/commits.html#get-the-diff-of-a-commit
        String url = String.format("/projects/%s/repository/commits/%s/diff", projectId, commitId);
        String jsonStr = getJsonStr(url);
        List<Object> files = JSON.parseArray(jsonStr, Object.class);
        return files == null ? 0 : files.size();
    }

    private CommitInfo stats(String projectId, String commitId) {
        String url = String.format("/projects/%s/repository/commits/%s", projectId, commitId);
        String jsonStr = getJsonStr(url);
        return JSON.parseObject(jsonStr, CommitInfo.class);
    }

    private <T> List<T> selectAllWithStore(String key, String url, Class<T> tClass) {
        String filePath = "D:/code/basic-java/gitlab/" + key + ".json";
        File file = new File(filePath);
        String json;
        if (USE_STORE && file.exists()) {
            try {
                json = CharStreams.toString(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8.name()));
                return JSON.parseArray(json, tClass);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        List<T> list = selectAll(url, tClass);
        if (USE_STORE) {
            try {
                file.createNewFile();
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(JSON.toJSONString(list));
                fileWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    private <T> List<T> selectAll(String url, Class<T> tClass) {
        String finalUrl = url + (url.contains("?") ? "&" : "?") + "page=";
        List<T> all = new ArrayList<>();
        int pageNo = 0;
        boolean next;
        do {
            String jsonStr = getJsonStr(finalUrl + (++pageNo));
            List<T> page = JSON.parseArray(jsonStr, tClass);
            next = page != null && !page.isEmpty();
            if (next) {
                all.addAll(page);
            }
        } while (next);
        return all;
    }

    private String getJsonStr(String url) {
        // url拼接：String finalUrl = URL_PREFIX + url + (url.contains("?") ? "&" : "?") + "private_token=" + PRIVATE_TOKEN;
        try {

            log.debug(url);
            SslUtils.ignoreSsl();
            HttpURLConnection connection = (HttpURLConnection) new URL(URL_PREFIX + url).openConnection();
            // 设置请求方法
            connection.setRequestMethod("GET");
            /// 请求头
            connection.setRequestProperty("PRIVATE-TOKEN", PRIVATE_TOKEN);
            // 发送请求
            connection.connect();
            // 检查响应码
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                return CharStreams.toString(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8.name()));
            }
            // 关闭连接
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
