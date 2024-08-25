package com.tom.springnote.chapter12.target;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;

import java.util.concurrent.TimeUnit;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName NestedCallAspect.java
 * @Description TODO
 * @createTime 2024年08月24日 11:19:00
 */
@Aspect
public class NestedCallAspect {

    @Around("execution(* method1(..)) || execution(* method2(..))")
    public Object timeCost(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        try {
            System.out.println("stopWatch.start()");
            stopWatch.start();
            return joinPoint.proceed();
        } finally {
            System.out.println("stopWatch.stop()");
            stopWatch.stop();
            System.out.printf("方法执行耗时%s\n", stopWatch.getTotalTime(TimeUnit.SECONDS));
        }
    }
}
