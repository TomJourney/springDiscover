package com.tom.springnote.chapter09.perclassadvice;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.context.ApplicationContextException;

import java.lang.reflect.Method;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName ExceptionHandleThrowsAdviceImpl.java
 * @Description TODO
 * @createTime 2024年08月18日 12:13:00
 */
public class ExceptionHandleThrowsAdviceImpl implements ThrowsAdvice {

    public void afterThrowing(Throwable t) {
        // 普通异常处理逻辑
        System.out.println("普通异常处理逻辑");
    }

    public void afterThrowing(RuntimeException e) {
        // 运行时异常处理逻辑
        System.out.println("运行时异常处理逻辑");
    }

    public void afterThrowing(Method method, Object[] args, Object target, ApplicationContextException e) {
        // ApplicationContext应用程序异常
        System.out.println("ApplicationContext应用程序异常");
    }
}
