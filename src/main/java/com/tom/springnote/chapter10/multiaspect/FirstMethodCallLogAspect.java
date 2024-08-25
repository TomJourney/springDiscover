package com.tom.springnote.chapter10.multiaspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName FirstAspect.java
 * @Description TODO
 * @createTime 2024年08月23日 15:58:00
 */
@Aspect
public class FirstMethodCallLogAspect implements Ordered {

    @Before("execution(* *.qryMsg(..))")
    public void requestLog() {
        System.out.println("FirstMethodCallLogAspect#requestLog()： 方法被调用");
    }

    @Override
    public int getOrder() {
        return 100;
    }
}
