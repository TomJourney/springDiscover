package com.tom.springnote.common.aop.methodinterceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

import java.util.concurrent.TimeUnit;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName TimeCostMethodInterceptor.java
 * @Description TODO
 * @createTime 2024年08月20日 10:05:00
 */
public class TimeCostMethodInterceptorImpl implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        try {
            System.out.println("stopWatch.start()");
            stopWatch.start();
            return invocation.proceed();
        } catch (Exception e) {
            System.out.println("抛出异常");
            e.printStackTrace();
        } finally {
            System.out.println("stopWatch.stop()");
            stopWatch.stop();
            System.out.printf("方法执行耗时%s\n", stopWatch.getTotalTime(TimeUnit.SECONDS));
        }
        return null;
    }
}
