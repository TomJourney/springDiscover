package com.tom.springnote.chapter11.faultbarrier;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName FaultBarrierAspect.java
 * @Description TODO
 * @createTime 2024年08月24日 07:35:00
 */
@Aspect
public class FaultBarrierAspect {

    @AfterThrowing(pointcut = "execution(* *(..))", throwing = "e")
    public void faultBarrierHandleException(Exception e) {
        System.out.println("[@AfterThrowing]: faultBarrierHandleException");
        throw new RuntimeException("被切面拦截处理后的异常，原生异常消息=[" + e.getMessage() + "]", e);
    }
}
