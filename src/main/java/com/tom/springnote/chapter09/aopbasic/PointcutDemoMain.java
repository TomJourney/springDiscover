package com.tom.springnote.chapter09.aopbasic;

import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName PointcutDemo.java
 * @Description TODO
 * @createTime 2024年08月18日 07:40:00
 */
public class PointcutDemoMain {

    public static void composablePointcut(String[] args) {
        ClassFilterImpl classFilterImpl = new ClassFilterImpl();
        MethodMatcherImpl methodMatcher = new MethodMatcherImpl();
        ComposablePointcut pointcut1 = new ComposablePointcut(classFilterImpl);
        ComposablePointcut pointcut2 = new ComposablePointcut(classFilterImpl, methodMatcher);
        // 逻辑运算， 求并运算
        ComposablePointcut unionedPointcut = pointcut1.union(pointcut2);
    }

    public static void annotaionMatchingPointcut(String[] args) {
        AnnotationMatchingPointcut annotationMatchingPointcut = new AnnotationMatchingPointcut(ControllerAdvice.class);
    }

    public static void jdkRegexpMethodPointcut(String[] args) {
        JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
        pointcut.setPattern(".*.match.*");
        pointcut.setPatterns(".*.match.*", ".*.matches.*");
    }

    public static void nameMatchMethodPointcut(String[] args) {
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedName("send");
        pointcut.setMappedNames("sendMsg", "sendEmail");
    }
}
