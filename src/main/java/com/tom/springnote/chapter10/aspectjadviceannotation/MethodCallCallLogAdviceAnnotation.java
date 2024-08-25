package com.tom.springnote.chapter10.aspectjadviceannotation;

import com.tom.springnote.common.aop.BusiMessage;
import org.aspectj.lang.JoinPoint;
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
public class MethodCallCallLogAdviceAnnotation {

    @Pointcut("execution(* *.qryMsg(..)) && args(String)")
    public void pointcut() {
        // pointcut
    }

    // 带上JoinPoint类型参数，获取方法参数列表（joinPoint必须作为第一个参数）
    // 通过 args(busiMessage) 把声明pointcut的参数名称绑定到方法调用的参数上
    @Before(value = "args(msgId)")
    public void printLogBefore(JoinPoint joinPoint, String msgId) {
        System.out.println("[@Before]方法执行开始，方法参数=" + Arrays.toString(joinPoint.getArgs()));
        System.out.println("[@Before]方法执行开始，方法参数=" + msgId);
    }

    // 引用定义的pointcut
    // 异常处理通知，获取异常对象e
    @AfterThrowing(pointcut = "pointcut()", throwing = "e")
    public void printLogAfterFinally(RuntimeException e) {
        System.out.println("[@AfterThrowing]异常处理开始");
        e.printStackTrace();
        System.out.println("[@AfterThrowing]异常处理结束");
    }

    // 通过 returning 属性绑定方法调用返回值
    @AfterReturning(value = "pointcut()", returning = "resultValue")
    public void printLogAfterReturning(BusiMessage resultValue) {
        System.out.printf("[@AfterReturning]方法执行结束(成功返回)： 方法执行返回值=%s\n", resultValue);
    }

    // 1. 不使用定义的pointcut，通知注解直接绑定pointcut表达式
    @After("execution(* *.qryMsg(..)) && args(String)")
    public void printLogAfterFinally() {
        System.out.println("[@After]方法执行结束afterFinally");
    }
}
