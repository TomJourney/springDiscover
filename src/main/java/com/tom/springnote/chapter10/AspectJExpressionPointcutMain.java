package com.tom.springnote.chapter10;

import org.springframework.aop.aspectj.AspectJExpressionPointcut;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName AspectJExpressionPointcutMain.java
 * @Description TODO
 * @createTime 2024年08月20日 17:42:00
 */
public class AspectJExpressionPointcutMain {
    public static void main(String[] args) {
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression("execution(* someMethodName(..))");
    }
}
