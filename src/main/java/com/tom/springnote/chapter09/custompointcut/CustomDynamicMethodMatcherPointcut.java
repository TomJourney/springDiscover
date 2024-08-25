package com.tom.springnote.chapter09.custompointcut;

import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName CustomDynamicMethodMatcherPointcut.java
 * @Description TODO
 * @createTime 2024年08月18日 11:20:00
 */
public class CustomDynamicMethodMatcherPointcut extends DynamicMethodMatcherPointcut {
    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {
        return method.getName().startsWith("send");
    }
}
