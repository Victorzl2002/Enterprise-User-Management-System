package org.victor.usercenterbackend.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: Victor_zl
 * @version: 1.0
 * @Description:
 */
@Data
public class BaseResponse<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 请求响应码
     */
    private int code;

    /**
     * 请求响应数据
     */
    private T data;

    /**
     * 请求响应消息
     */
    private String message;

    public BaseResponse(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public BaseResponse(int code,String message) {
        this.code = code;
        this.message = message;
    }
}