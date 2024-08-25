package com.tom.springnote.chapter10;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName MockAspect.java
 * @Description TODO
 * @createTime 2024年08月20日 17:54:00
 */
@Aspect
public class MockAspect {

    @Pointcut("execution(* destory(..))")
    public void destory() {
    }

    @After("destory()")
    public void cleanUpResourcesIfNeed() {
    }
}
