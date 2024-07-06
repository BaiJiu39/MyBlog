package com.BaiJiu.POJO.DTO;

import lombok.Data;

@Data
public class UserTableRegisterDTO {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 密码
     */
    private String reenteredPassword;


}
