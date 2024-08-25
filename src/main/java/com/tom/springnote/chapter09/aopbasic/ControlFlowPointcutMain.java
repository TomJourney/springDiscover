package com.tom.springnote.chapter09.aopbasic;

import org.aopalliance.aop.Advice;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.support.ControlFlowPointcut;

import java.lang.reflect.Method;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName ControlFlowPointcutMain.java
 * @Description TODO
 * @createTime 2024年08月18日 11:04:00
 */
public class ControlFlowPointcutMain {
    public static void main(String[] args) {
        ControlFlowPointcut controlFlowPointcut =
                new ControlFlowPointcut(TargetCaller.class, "upstreamMethod1");
        // 声明横切逻辑
        Advice advice = new AfterReturningAdvice() {
            @Override
            public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {

            }
        };
    }
}
