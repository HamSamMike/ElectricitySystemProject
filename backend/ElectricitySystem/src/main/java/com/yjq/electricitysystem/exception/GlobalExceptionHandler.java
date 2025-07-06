package com.yjq.electricitysystem.exception;

import com.yjq.electricitysystem.common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice("com.yjq.electricitytest.controller")
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody // 返回json串
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.error();
    }

    @ExceptionHandler(CustomException.class)
    @ResponseBody // 返回json串
    public Result error(CustomException e) {
        e.printStackTrace();

        return Result.error(e.getcode(), e.getMessage());
    }
}
