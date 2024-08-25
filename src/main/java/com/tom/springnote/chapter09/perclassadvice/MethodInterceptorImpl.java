package com.tom.springnote.chapter09.perclassadvice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName MethodInterceptorImpl.java
 * @Description TODO
 * @createTime 2024年08月18日 12:33:00
 */
public class MethodInterceptorImpl implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        try {
            stopWatch.start();
            return invocation.proceed();
        } finally {
            stopWatch.stop();
        }
    }
}
