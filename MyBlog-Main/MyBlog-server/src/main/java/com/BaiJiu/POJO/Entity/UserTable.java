package com.BaiJiu.POJO.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName user_table
 */
@TableName(value ="user_table")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserTable implements Serializable {
    /**
     * 用户id
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户名
     */
    @TableField(value = "username")
    private String username;

    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 注册时间
     */
    @TableField(value = "reg_time")
    private LocalDateTime regTime;

    /**
     * 身份信息最后修改时间
     */
    @TableField(value = "last_update_time")
    private LocalDateTime lastUpdateTime;



    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}