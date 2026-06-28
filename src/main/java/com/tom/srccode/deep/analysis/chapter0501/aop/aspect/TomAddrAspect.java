package com.tom.srccode.deep.analysis.chapter0501.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author tom
 * @version 1.0.0
 * @Description TODO
 * @createTime 2026年06月28日 17:58:00
 */
@Aspect
@Slf4j
public class TomAddrAspect {

    @Pointcut("execution(* *.test(..))")
    public void test() {
        // do nothing.
    }

    @Before("test()")
    public void beforeTest() {
        log.info("before test()");
    }

    @After("test()")
    public void afterTest() {
        log.info("after test()");
    }

    @Around("test()")
    public Object aroundTest(ProceedingJoinPoint proceedingJoinPoint) {
        log.info("around: before test()");
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            log.error("test() 目标方法调用异常", e);
            throw new RuntimeException("test() 目标方法调用异常");
        }
        log.info("around: after test()");
        return result;
    }

}
