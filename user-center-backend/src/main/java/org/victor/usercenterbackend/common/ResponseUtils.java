package org.victor.usercenterbackend.common;

/**
 * @author: Victor_zl
 * @version: 1.0
 * @Description:
 */
public interface ResponseUtils {

    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(0, data,"success");
    }

    public static <T> BaseResponse<T> error(ErrorResponse errorResponse) {
        return new BaseResponse<>(errorResponse.getCode(),  errorResponse.getMessage());
    }

     public static <T> BaseResponse<T> error(int code, String message) {
        return new BaseResponse<>(code, message);
    }
}