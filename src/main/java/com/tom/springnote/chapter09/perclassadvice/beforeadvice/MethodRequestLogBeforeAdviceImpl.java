package com.tom.springnote.chapter09.perclassadvice.beforeadvice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterAdvice;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName CheckAuthBeforeAdviceImpl.java
 * @Description 方法请求日志前置通知
 * @createTime 2024年08月21日 14:43:00
 */
public class MethodRequestLogBeforeAdviceImpl implements MethodBeforeAdvice, AfterReturningAdvice, BeforeAdvice, MethodInterceptor {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.printf("MethodBeforeAdvice#before()：请求日志，方法名=[%s]\n", method.getName());
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        return null;
    }

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {

    }
}
