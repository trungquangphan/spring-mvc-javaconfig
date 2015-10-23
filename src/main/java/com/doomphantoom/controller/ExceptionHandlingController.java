package com.doomphantoom.controller;

import com.doomphantoom.dto.BaseResponse;
import com.doomphantoom.exception.AnnotationInvalidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by doomphantom on 23/10/2015.
 */
@ControllerAdvice
public class ExceptionHandlingController {
    @ExceptionHandler(value = IllegalStateException.class)
    @ResponseBody
    public BaseResponse<?> handleIllegalStateException(IllegalStateException ex) {
        BaseResponse<?> baseResponse = new BaseResponse<>();
        baseResponse.setBody(null);
        baseResponse.setResultCode("1001");
        baseResponse.setResultCode(ex.getMessage());
        return baseResponse;
    }


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BaseResponse<?> handleIllegalStateException(Exception ex) {
        Throwable throwable = ex.getCause();
        if (throwable instanceof AnnotationInvalidException) {
            BaseResponse<?> baseResponse = new BaseResponse<>();
            baseResponse.setBody(null);
            baseResponse.setResultCode("1001");
            baseResponse.setResultDescription(ex.getCause().getMessage());
            return baseResponse;
        }
        BaseResponse<?> baseResponse = new BaseResponse<>();
        baseResponse.setBody(null);
        baseResponse.setResultCode("1000");
        baseResponse.setResultDescription(ex.getCause().getMessage());
        return baseResponse;

    }
}
