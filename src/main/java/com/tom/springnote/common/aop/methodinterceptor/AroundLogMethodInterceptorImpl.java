package com.tom.springnote.common.aop.methodinterceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName AroundLogMethodInterceptorImpl.java
 * @Description TODO
 * @createTime 2024年08月20日 10:23:00
 */
public class AroundLogMethodInterceptorImpl implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("收集请求报文");
        Object result = invocation.proceed();
        System.out.println("收集响应报文");
        return result;
    }
}
