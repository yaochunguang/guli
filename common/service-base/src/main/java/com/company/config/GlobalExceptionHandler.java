package com.company.config;

import com.company.common.Result;
import com.company.exception.GuLiException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: yaochunguang
 * @date: 2021-03-05 16:55
 * @description: 统一异常处理
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception exception) {
        exception.printStackTrace();
        return Result.error().message(exception.getMessage());
    }


    @ExceptionHandler(GuLiException.class)
    @ResponseBody
    public Result error(GuLiException e) {
        e.printStackTrace();
        return Result.error().message(e.getMessage()).code(e.getErrorCode());
    }
}
