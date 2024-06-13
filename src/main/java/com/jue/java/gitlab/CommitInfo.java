package com.jue.java.gitlab;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 统计文件信息
 *
 * @author JUE
 */
@Data
public class CommitInfo {

    /**
     * 提交id
     */
    @ExcelIgnore
    private String id;

    /**
     * 父组件id
     */
    @ExcelIgnore
    private List<String> parent_ids;

    /**
     * 项目
     */
    @ExcelProperty("项目")
    private String proj;

    /**
     * 模块
     */
    @ExcelProperty("模块")
    private String module;

    /**
     * 所属分支
     */
    @ExcelProperty("所属分支")
    private String branch;

    /**
     * 提交人
     */
    @ExcelProperty("提交人")
    private String author_name;

    /**
     * 代码提交记录
     */
    @ExcelIgnore
    private String title;

    /**
     * 代码提交记录
     */
    @ExcelProperty("代码提交记录")
    private String message;

    @ExcelProperty("涉及文件数量")
    private Integer fileCount;

    @ExcelIgnore
    @ExcelProperty("涉及变化数量")
    private Integer changeCount;

    /**
     * 创建时间
     */
    @ExcelIgnore
    private LocalDateTime created_at;

    /**
     * 提交时间
     */
    @ExcelProperty("提交时间")
    private LocalDateTime committed_date;

    /**
     * 文件信息
     */
    @ExcelIgnore
    private CommitStats stats;

    public void setStats(CommitStats stats) {
        this.stats = stats;
        this.changeCount = stats == null ? 0 : stats.getTotal();
    }
}
