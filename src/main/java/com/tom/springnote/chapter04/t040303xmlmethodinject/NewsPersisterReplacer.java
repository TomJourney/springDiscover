package com.tom.springnote.chapter04.t040303xmlmethodinject;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName NewsPersisterReplacer.java
 * @Description TODO
 * @createTime 2024年08月03日 17:13:00
 */
public class NewsPersisterReplacer implements MethodReplacer {

    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        System.out.println("execute method before");
        System.out.println("execute busi ");
        System.out.println(method);
        System.out.println(args);
        System.out.println(obj);
        System.out.println("execute method after");
        return null;
    }
}
