package com.tom.springnote.chapter10.basedschema.advice;

import com.tom.springnote.common.aop.BusiMessage;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName CallTaskBeforeAnnotation.java
 * @Description TODO
 * @createTime 2024年08月23日 11:39:00
 */
public class BasedSchemaMethodLogAdvice {

    public void printLogBefore(JoinPoint joinPoint, String msgId) {
        System.out.println("[@Before]方法执行开始，方法参数=" + Arrays.toString(joinPoint.getArgs()));
        System.out.println("[@Before]方法执行开始，方法参数=" + msgId);
    }

    public void printLogAfterThrowing(RuntimeException e) {
        System.out.println("[@AfterThrowing]异常处理开始");
        e.printStackTrace();
        System.out.println("[@AfterThrowing]异常处理结束");
    }

    public void printLogAfterReturning() {
        System.out.printf("[@AfterReturning]方法执行结束(成功返回)\n");
    }

    public void printLogAfterFinally() {
        System.out.println("[@After]方法执行结束afterFinally");
    }

    public Object printLogAroundAdvice(ProceedingJoinPoint joinPoint, String msgId) {
        System.out.println("[@Around]方法调用开始");
        System.out.println("[@Around]参数值 = " + msgId);
        try {
//            joinPoint.proceed();  // 可以无参调用
            return joinPoint.proceed(new Object[]{msgId}); // [有参调用] 显然这里可以偷梁换柱
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("[@Around]方法调用结束");
        }
    }
}
