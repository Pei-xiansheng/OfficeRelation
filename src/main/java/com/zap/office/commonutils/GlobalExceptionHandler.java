package com.zap.office.commonutils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: ZhuApeng
 * @Title: GlobalExceptionHandler
 * @ProjectName: OfficeRelation
 * @Description:
 * @date: 2021/12/2 10:49
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    //创建自定义返回信息
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result exceptionHandler(Exception e){
        e.printStackTrace();
        return Result.error().msg("后端系统出现异常！！！");
    }

    //创建自定义异常类
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public Result ownExceptionHandler(MyException me){
        me.printStackTrace();
        return Result.error().code(me.getCode()).msg(me.getMessage());
    }
}
