package com.awolau.vue.demo.vo;

import com.awolau.vue.demo.enums.ResponseStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 统一返回
 *
 * @create 2017-09-18 19:12
 **/
@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T extends Serializable> {
    private int code;
    private String msg;
    private T data;

    public Result(ResponseStatus status) {
        this.code = status.getCode();
        this.msg = status.getMsg();
    }

    public static <T extends Serializable> Result<T> success(){
        return new Result<>(ResponseStatus.SUCCESS);
    }

    public static <T extends Serializable> Result<T> success(T data){
        return new Result<>(ResponseStatus.SUCCESS.getCode(), null, data);
    }

    public static <T extends Serializable> Result<T> failed(){
        return new Result<>(ResponseStatus.FAILED);
    }

    public static <T extends Serializable> Result<T> failed(String msg){
        return new Result<>(ResponseStatus.FAILED.getCode(), msg, null);
    }

}

