package com.BaiJiu.mapper;

import com.BaiJiu.POJO.Entity.UserTable;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
* @author miku
* @description 针对表【user_table】的数据库操作Mapper
* @createDate 2024-05-23 14:26:40
* @Entity com.BaiJiu.POJO.Entity.UserTable
*/
@Mapper
public interface UserTableMapper extends BaseMapper<UserTable> {

    @Select("select * from user_table where username = #{username}")
    UserTable getByUsername(String username);


}




