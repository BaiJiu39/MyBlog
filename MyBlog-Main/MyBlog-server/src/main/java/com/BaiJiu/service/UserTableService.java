package com.BaiJiu.service;

import com.BaiJiu.POJO.DTO.UserTableLoginDTO;
import com.BaiJiu.POJO.DTO.UserTableRegisterDTO;
import com.BaiJiu.POJO.Entity.UserTable;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author miku
* @description 针对表【user_table】的数据库操作Service
* @createDate 2024-05-23 14:26:40
*/
public interface UserTableService extends IService<UserTable> {

    //用户登录
    String register(UserTableRegisterDTO registerDTO);

    UserTable login(UserTableLoginDTO userTableLoginDTO);
}
