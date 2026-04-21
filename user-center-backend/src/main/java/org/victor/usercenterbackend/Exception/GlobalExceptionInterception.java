package org.victor.usercenterbackend.Exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.victor.usercenterbackend.common.BaseResponse;
import org.victor.usercenterbackend.common.ErrorResponse;
import org.victor.usercenterbackend.common.ResponseUtils;

/**
 * @author: Victor_zl
 * @version: 1.0
 * @Description:
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionInterception {
    @ExceptionHandler(GlobalResponseException.class)
    public BaseResponse globalResponseException(GlobalResponseException e) {
        log.error(e.getMessage());
        return ResponseUtils.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public BaseResponse exception(RuntimeException e) {
        log.error(e.getMessage());
        return ResponseUtils.error(500, e.getMessage());
    }
}