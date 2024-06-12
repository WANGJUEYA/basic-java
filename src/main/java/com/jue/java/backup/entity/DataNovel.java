package com.jue.java.backup.entity;

import com.jue.java.backup.constant.TableField;
import com.jue.java.backup.constant.TableName;
import lombok.Data;

@TableName("DATA_NOVEL")
@Data
public class DataNovel implements DataBase {

    String id;

    /**
     * 作品名称
     */
    @TableField("NAME")
    String name;

    /**
     * 作者id
     */
    @TableField("AUTHOR_ID")
    String authorId;

    /**
     * 作者名称
     */
    @TableField("AUTHOR_NAME")
    String authorName;

    /**
     * 存储路径
     */
    @TableField("PATH")
    String path;

    /**
     * 附件状态
     */
    @TableField("STATUS")
    String status;

}
