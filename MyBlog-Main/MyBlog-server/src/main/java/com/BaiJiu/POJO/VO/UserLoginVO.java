package com.BaiJiu.POJO.VO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserLoginVO {

    //id
    private Integer id;

    //用户名
    private String userName;


    //jwt令牌
    private String token;

}
