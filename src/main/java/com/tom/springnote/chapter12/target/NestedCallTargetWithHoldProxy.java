package com.tom.springnote.chapter12.target;

import org.springframework.aop.framework.AopContext;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName NestableTarget.java
 * @Description TODO
 * @createTime 2024年08月24日 11:16:00
 */
public class NestedCallTargetWithHoldProxy {

    public void method1() {
        System.out.println("NestedCallTarget#method1() 方法被调用");
        NestedCallTargetWithHoldProxy proxy = (NestedCallTargetWithHoldProxy) AopContext.currentProxy();
        proxy.method2();
    }

    public void method2() {
        System.out.println("NestedCallTarget#method2() 方法被调用");
    }
}
