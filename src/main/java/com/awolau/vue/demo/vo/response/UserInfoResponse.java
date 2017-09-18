package com.awolau.vue.demo.vo.response;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 用户信息
 *
 * @create 2017-09-18 20:05
 **/
@Data
@Builder
public class UserInfoResponse implements Serializable {
    private List<String> permissions;
}
