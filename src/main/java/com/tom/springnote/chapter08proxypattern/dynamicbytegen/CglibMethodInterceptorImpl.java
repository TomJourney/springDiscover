package com.tom.springnote.chapter08proxypattern.dynamicbytegen;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName DynamicByteGenProxy.java
 * @Description TODO
 * @createTime 2024年08月17日 09:30:00
 */
public class CglibMethodInterceptorImpl implements MethodInterceptor {

    private final Object target;

    public CglibMethodInterceptorImpl(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("send() execute : before");
        Object result = method.invoke(target, args);
        System.out.println("send() execute : after");
        return result;
    }
}
