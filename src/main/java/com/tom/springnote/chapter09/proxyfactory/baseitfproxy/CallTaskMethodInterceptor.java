package com.tom.springnote.chapter09.proxyfactory.baseitfproxy;

import com.tom.springnote.utils.BusiDatetimeUtils;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName DbLogMethodInterceptor.java
 * @Description TODO
 * @createTime 2024年08月19日 18:52:00
 */
public class CallTaskMethodInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println(BusiDatetimeUtils.getNowText() + " before execute method.");
        Object result = invocation.proceed();
        System.out.println(BusiDatetimeUtils.getNowText() + " after execute method.");
        return result;
    }
}
