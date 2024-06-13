package com.jue.java.gitlab;

import lombok.Data;

/**
 * 项目信息
 *
 * @author JUE
 */
@Data
public class CommitProject {

    /**
     * 项目id
     */
    private String id;

    /**
     * 项目名称
     */
    private String name;

    /**
     * 项目名称
     */
    private String path_with_namespace;

}
