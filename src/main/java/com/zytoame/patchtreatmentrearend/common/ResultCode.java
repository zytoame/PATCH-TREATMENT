package com.zytoame.patchtreatmentrearend.common;

/**
 * 响应码枚举
 */
public enum ResultCode {
    SUCCESS(200, "操作成功"),
    FAIL(400, "操作失败"),
    UNAUTHORIZED(401,"未授权"),
    FORBIDDEN(403,"禁止访问"),
    NOT_FOUND(404,"资源不存在"),
    INTERNAL_ERROR(500,"服务器内部错误"),

    PARAM_ERROR(1001,"参数错误"),
    PATIENT_NOT_FOUND(1002,"病人不存在"),
    TREATMENT_NOT_FOUND(1003,"治疗记录不存在"),
    USER_NOT_FOUND(1004,"用户不存在"),
    LOGIN_FAILED(1005,"登录失败"),
    FILE_UPLOAD_FAILED(1006,"文件上传失败");

    private final int code;
    private final String message;
    private ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
