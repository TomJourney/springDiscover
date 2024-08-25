package com.tom.springnote.chapter09.custompointcut;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName CustomPointcut.java
 * @Description TODO
 * @createTime 2024年08月18日 11:17:00
 */
public class CustomStaticMethodMatcherPointcut extends StaticMethodMatcherPointcut {

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return "send".equals(method.getName());
    }
}
