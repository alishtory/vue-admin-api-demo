package com.awolau.vue.demo.enums;

/**
 * Created by lenovo on 2017/9/18.
 */
public enum ResponseStatus {

    SUCCESS(0, "SUCCESS"),

    FAILED(10001, "请求处理失败！"),

    REQUIRED_LOGIN(10302, "请先登录"),

    PERMISSION_DENIED(10403, "没有权限");


    private int code;
    private String msg;

    ResponseStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
