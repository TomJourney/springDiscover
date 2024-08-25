package com.tom.springnote.chapter10.aspectjpointcutannotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;

import java.util.concurrent.TimeUnit;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName AspectByAspectJAnnotation.java
 * @Description TODO
 * @createTime 2024年08月23日 09:41:00
 */
@Aspect
public class AspectJPointcutAnnotation {

    // @Pointcut注解的逻辑运算
    @Pointcut("execution(public void *.call(..)) || execution(public void *.call2(..))")
    private void callPointcut() {
        // pointcut
    }

    // 引用Aspect内部pointcut
    @Pointcut("callPointcut()")
    public void referInnerPointcut() {
        // pointcut
    }

    // 引用Aspect外部pointcut
    @Pointcut("com.tom.springnote.chapter10.aspectjannotation.TimeCostAspectByAnnotation.pointcutName()")
    public void referOuterPointcut() {
        // pointcut
    }

    @Around("referInnerPointcut()")
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
