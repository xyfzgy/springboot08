package com.gaoyu.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author：高宇
 * @Description：
 * @Data Created in 2026-06-2615:03
 * @Modified By:
 */
@Component
@Aspect
@Order(1)
public class LogAdvice {
    @Before("execution(* com.gaoyu.controller.*.*(..))")
    public void before(JoinPoint point){
        //获取类信息
        String className = point.getTarget().getClass().getSimpleName();
        //获取方法信息
        String methodName = point.getSignature().getName();
        System.out.println(className + "." + methodName + "执行前");
    }
}