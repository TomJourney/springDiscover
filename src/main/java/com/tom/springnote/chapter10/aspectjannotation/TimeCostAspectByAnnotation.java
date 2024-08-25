package com.tom.springnote.chapter10.aspectjannotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;

import java.util.concurrent.TimeUnit;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName TimeCostMethodInterceptor.java
 * @Description TODO
 * @createTime 2024年08月20日 10:05:00
 */
@Aspect
public class TimeCostAspectByAnnotation {

    @Pointcut("execution(public void *.call(..))")
    public void pointcutName() {
        // pointcut
    }

    @Around("pointcutName()")
    public Object timeCost(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        try {
            System.out.println("stopWatch.start()");
            stopWatch.start();
            return joinPoint.proceed();
        } catch (Exception e) {
            System.out.println("抛出异常");
            e.printStackTrace();
        } finally {
            System.out.println("stopWatch.stop()");
            stopWatch.stop();
            System.out.printf("方法执行耗时%s\n", stopWatch.getTotalTime(TimeUnit.SECONDS));
        }
        return null;
    }
}
