package com.BaiJiu.service.Impl;

import com.BaiJiu.POJO.DTO.UserTableLoginDTO;
import com.BaiJiu.POJO.DTO.UserTableRegisterDTO;
import com.BaiJiu.POJO.Entity.UserTable;
import com.BaiJiu.common.constant.MessageConstant;
import com.BaiJiu.common.exception.AccountNotFoundException;
import com.BaiJiu.common.exception.PasswordErrorException;
import com.BaiJiu.common.exception.UsernameAlreadyExistsException;
import com.BaiJiu.mapper.UserTableMapper;
import com.BaiJiu.service.UserTableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author miku
 * @description 针对表【user_table】的数据库操作Service实现
 * @createDate 2024-05-23 14:26:40
 */
@Service
public class UserTableServiceImpl extends ServiceImpl<UserTableMapper, UserTable> implements UserTableService {
    @Autowired
    UserTableMapper userTableMapper;

    public String register(UserTableRegisterDTO UserTableRegisterDTO) {
        UserTable userTable = new UserTable();
        BeanUtils.copyProperties(UserTableRegisterDTO, userTable);

        //查询用户信息
        UserTable userTables = userTableMapper.getByUsername(userTable.getUsername());
        if (userTables == null) {
            userTable.setRegTime(LocalDateTime.now());
            userTable.setLastUpdateTime(LocalDateTime.now());
            userTable.setEmail("2641574387@qq.com");
            userTableMapper.insert(userTable);
            return "注册成功";
        }
        //用户名重复
        if(userTables.getUsername().equals(userTable.getUsername())) {
            //用户名重复
            throw  new UsernameAlreadyExistsException(MessageConstant.ALREADY_EXISTS);
        }

        return "注册异常";
    }

    @Override
    public UserTable login(UserTableLoginDTO userTableLoginDTO) {
        String username = userTableLoginDTO.getUsername();
        String password = userTableLoginDTO.getPassword();
        //查询数据库数据
        UserTable userTables = userTableMapper.getByUsername(username);
        if (userTables == null) {
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }
        //密码对比

        if (!password.equals(userTables.getPassword())) {
            //密码错误
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }
        return userTables;
    }
}




