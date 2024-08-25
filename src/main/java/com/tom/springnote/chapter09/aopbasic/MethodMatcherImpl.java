package com.tom.springnote.chapter09.aopbasic;

import org.springframework.aop.MethodMatcher;

import java.lang.reflect.Method;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName MethodMatcherImpl.java
 * @Description TODO
 * @createTime 2024年08月18日 10:41:00
 */
public class MethodMatcherImpl implements MethodMatcher {
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return "send".equals(method.getName());
    }

    @Override
    public boolean isRuntime() {
        return false;
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {
        return false;
    }
}
