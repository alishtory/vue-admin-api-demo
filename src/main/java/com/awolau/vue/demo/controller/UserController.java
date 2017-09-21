package com.awolau.vue.demo.controller;

import com.awolau.vue.demo.enums.ResponseStatus;
import com.awolau.vue.demo.vo.Result;
import com.awolau.vue.demo.vo.request.LoginUserRequest;
import com.awolau.vue.demo.vo.response.UserInfoResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 用户控制器
 *
 * @create 2017-09-18 19:57
 **/
@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/user")
public class UserController {

    private static final String LOGIN_USER_KEY = "LOGIN_USER_KEY";

    @PostMapping("/login")
    public Result<Serializable> login(@RequestBody LoginUserRequest user, HttpSession session){
        log.info("user: {}", user);
        if (user.getUsername() == null){
            return Result.failed("请提供用户名、密码");
        }else if("admin".equals(user.getUsername())){
            session.setAttribute(LOGIN_USER_KEY, "admin");
        }else{
            session.setAttribute(LOGIN_USER_KEY, "user");
        }
        return Result.success();
    }

    @GetMapping("/user_info")
    public Result<UserInfoResponse> userInfo(HttpSession session){
        String userName = (String) session.getAttribute(LOGIN_USER_KEY);
        if (userName == null){
            return new Result<>(ResponseStatus.REQUIRED_LOGIN);
        }
        List<String> pers = Arrays.asList("user.add", "user.update");
        if ("admin".equals(userName)){
            pers = Arrays.asList("user.add", "user.update", "admin.table");
        }
        UserInfoResponse data = UserInfoResponse.builder().permissions(pers).build();
        return Result.success(data);
    }

}
