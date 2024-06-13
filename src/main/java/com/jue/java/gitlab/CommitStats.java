package com.jue.java.gitlab;

import lombok.Data;

/**
 * 统计文件信息
 *
 * @author JUE
 */
@Data
public class CommitStats {

    private Integer additions;
    private Integer deletions;
    private Integer total;

}
