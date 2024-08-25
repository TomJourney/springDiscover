package com.tom.springnote.chapter08proxypattern.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName StaticProxyMsgSendImpl.java
 * @Description TODO
 * @createTime 2024年08月17日 07:20:00
 */
public class SenderInvocationHandler implements InvocationHandler {

    private Object target;

    public SenderInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        if ("send".equals(method.getName())) {
            System.out.println("send() execute : before");
            result = method.invoke(target, args);
            System.out.println("send() execute : after");
        } else {
            result = method.invoke(target, args);
        }
        return result;
    }
}
