package com.BaiJiu.controller;

import com.BaiJiu.POJO.DTO.UserTableLoginDTO;
import com.BaiJiu.POJO.DTO.UserTableRegisterDTO;
import com.BaiJiu.POJO.Entity.UserTable;
import com.BaiJiu.common.utils.JwtUtil;
import com.BaiJiu.result.Result;
import com.BaiJiu.service.UserTableService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    UserTableService userTableService;

    @PostMapping("/register")
    public Result createUser(@RequestBody UserTableRegisterDTO registerDTO) {
        if (registerDTO.getPassword().equals(registerDTO.getReenteredPassword())) {
            String msg = userTableService.register(registerDTO);
            return Result.msg(msg);
        }
        return Result.error("注册失败");

    }

    @PostMapping("/login")
    public Result login(@RequestBody UserTableLoginDTO userTableLoginDTO) {
        UserTable userTable = userTableService.login(userTableLoginDTO);

        Map<String, Object> claims = new HashMap<>();
        claims.put(userTable.getUsername(), userTable.getUserId());
        String token = JwtUtil.createJWT(claims);

        return Result.success(token,"登录成功");
    }





}
