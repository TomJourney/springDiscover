package com.tom.springnote.chapter09.perclassadvice.ordered;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName MethodCallCounterBeforeAdviceImpl.java
 * @Description TODO
 * @createTime 2024年08月21日 21:10:00
 */
public class MethodCallCounterBeforeAdviceImpl implements MethodBeforeAdvice {
    private static final AtomicInteger COUNTER = new AtomicInteger(0);

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.printf("MethodCallCounterBeforeAdviceImpl#before：方法[%s]第[%s]次被调用\n", method.getName(), COUNTER.incrementAndGet());
    }
}
