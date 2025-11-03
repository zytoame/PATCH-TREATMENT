package com.zytoame.patchtreatmentrearend.common;

import lombok.Data;
import java.io.Serializable;

/**
 * 统一响应结果类
 */
@Data
public class Result<T> implements Serializable {
    private int code;
    private String msg;
    private T data;
    private long timestamp;

    public Result(){
        this.timestamp = System.currentTimeMillis();
    }

    public Result(int code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * 成功响应（无数据
     */
    public static <T> Result<T> success(){
        return new Result<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(),null);
    }

    /**
     * 成功响应（有数据
     */
    public static <T> Result<T> success(T data){
        return new Result<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(),data);
    }

    /**
     * 成功响应（自定义数据
     */
    public static <T> Result<T> success(String msg, T data){
        return new Result<>(ResultCode.SUCCESS.getCode(), msg,data);
    }

    /**
     * 失败响应
     */
    public static <T> Result<T> fail(ResultCode resultCode){
        return new Result<>(resultCode.getCode(), resultCode.getMessage(),null);
    }

    /**
     * 失败响应
     */
    public static <T> Result<T> fail(int code, String msg){
        return new Result<>(code, msg,null);
    }

    /**
     * 失败响应
     */
    public static <T> Result<T> fail(String msg){
        return new Result<>(ResultCode.FAIL.getCode(), msg,null);
    }
}
