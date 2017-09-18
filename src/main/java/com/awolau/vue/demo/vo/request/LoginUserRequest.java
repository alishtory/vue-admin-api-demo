package com.awolau.vue.demo.vo.request;

import lombok.Data;

/**
 * 登录请求
 *
 * @create 2017-09-18 20:00
 **/
@Data
public class LoginUserRequest {

    private String username;
    private String password;
}
