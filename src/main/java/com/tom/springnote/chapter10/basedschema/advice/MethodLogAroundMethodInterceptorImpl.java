package com.tom.springnote.chapter10.basedschema.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName MethodLogAroundMethodInterceptor.java
 * @Description TODO
 * @createTime 2024年08月23日 17:53:00
 */
public class MethodLogAroundMethodInterceptorImpl implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("MethodLogAroundMethodInterceptorImpl#invoke()： 方法调用前");
        try {
            return invocation.proceed();
        } finally {
            System.out.println("MethodLogAroundMethodInterceptorImpl#invoke()： 方法调用后");
        }
    }
}
