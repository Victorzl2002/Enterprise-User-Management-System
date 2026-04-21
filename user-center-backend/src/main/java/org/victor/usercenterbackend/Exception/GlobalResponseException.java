package org.victor.usercenterbackend.Exception;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.victor.usercenterbackend.common.BaseResponse;
import org.victor.usercenterbackend.common.ErrorResponse;
import org.victor.usercenterbackend.common.ResponseUtils;

/**
 * @author: Victor_zl
 * @version: 1.0
 * @Description:
 */
public class GlobalResponseException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private final int code;


    public GlobalResponseException(int code, String message) {
        super(message);
        this.code = code;
    }

    public GlobalResponseException(ErrorResponse errorResponse) {
        super(errorResponse.getMessage());
        this.code = errorResponse.getCode();
    }

    public int getCode() {
        return code;
    }
}