package com.gaoyu.goodsorder.common;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 * @RestControllerAdvice = @ControllerAdvice + @ResponseBody
 * 作用：拦截所有 Controller 抛出的异常，统一转成 Result 格式返回
 *
 * 优先级：精确匹配优先
 * - 抛出 IllegalArgumentException → 走第一个方法
 * - 抛出其他 Exception → 走第二个方法
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /** 处理非法参数异常 */
    @ExceptionHandler(IllegalArgumentException.class)
    public Result<Void> handleIllegalArgument(IllegalArgumentException e) {
        return Result.fail(ResultCode.BAD_REQUEST.getCode(), e.getMessage());
    }

    /** 兜底：处理所有未捕获的异常 */
    @ExceptionHandler(Exception.class)
    public Result<Void> handleException(Exception e) {
        // 实际项目中应该打日志，这里简单输出到控制台
        e.printStackTrace();
        return Result.fail(ResultCode.INTERNAL_ERROR);
    }
}