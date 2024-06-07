package com.jue.java.backup.entity;

import com.jue.java.backup.constant.TableField;
import com.jue.java.backup.constant.TableName;
import lombok.Data;

@Data
@TableName("DATA_MUSIC")
public class DataMusic implements DataBase {

    String id;

    /**
     * 出生年份
     */
    @TableField("BIRTH_YEAR")
    String birthYear;

    /**
     * 音乐名称
     */
    @TableField("NAME")
    String name;

    /**
     * 专辑id
     */
    @TableField("ALBUM_ID")
    String albumId;

    /**
     * 专辑名称
     */
    @TableField("ALBUM_NAME")
    String albumName;

    /**
     * 歌手id
     */
    @TableField("ART_ID")
    String artId;

    /**
     * 歌手名称
     */
    @TableField("ART_NAME")
    String artName;

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
