package com.BaiJiu.POJO.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName articles
 */
@TableName(value ="articles")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Articles implements Serializable {
    /**
     * 文章id
     */
    @TableId(value = "article_id", type = IdType.AUTO)
    private Integer articleId;

    /**
     * 文章标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 文章内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDate createTime;

    /**
     * 最后修改时间
     */
    @TableField(value = "last_update_time")
    private LocalDate lastUpdateTime;

    /**
     * 是否原创
     */
    @TableField(value = "is_original")
    private Integer isOriginal;

    /**
     * 点赞数量
     */
    @TableField(value = "like_count")
    private Integer likeCount;

    /**
     * 浏览量
     */
    @TableField(value = "view_count")
    private Integer viewCount;


    /**
     * 文章简介
     */
    @TableField(value = "summary")
    private String summary;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}