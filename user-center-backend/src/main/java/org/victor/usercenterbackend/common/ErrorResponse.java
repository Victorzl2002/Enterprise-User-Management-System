package org.victor.usercenterbackend.common;

/**
 * @author: Victor_zl
 * @version: 1.0
 * @Description:
 */
public enum ErrorResponse {

    ERROR(-1, "请求失败"),
    PARAMS_ERROR(10000, "请求参数错误"),
    NULL_ERROR(10001, "请求数据为空"),
    NOT_LOGIN(10002, "用户未登录"),
    NO_AUTH(10003, "用户无权限"),
    SYSTEM_ERROR(99999, "系统异常");

    private final int code;
    private final String message;

    ErrorResponse(int code, String message) {
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