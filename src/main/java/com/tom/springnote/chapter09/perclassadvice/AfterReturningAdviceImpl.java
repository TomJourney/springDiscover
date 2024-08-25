package com.tom.springnote.chapter09.perclassadvice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName AfterReturningAdviceImpl.java
 * @Description TODO
 * @createTime 2024年08月18日 12:26:00
 */
public class AfterReturningAdviceImpl implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        // 方法执行成功后发送通知
    }
}
