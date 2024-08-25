package com.tom.springnote.chapter10.aspectjadviceannotation;

import com.tom.springnote.common.aop.BusiMessage;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName CallTaskBeforeAnnotation.java
 * @Description TODO
 * @createTime 2024年08月23日 11:39:00
 */
@Aspect
public class MethodCallCallLogAroundAdviceAnnotation {

    // 环绕通知对应方法的第一个参数类型是 ProceedingJoinPoint
    @Around("execution(* *.qryMsg(..)) && args(msgId)")
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
