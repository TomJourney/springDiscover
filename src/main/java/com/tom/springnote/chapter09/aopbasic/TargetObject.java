package com.tom.springnote.chapter09.aopbasic;

import org.springframework.stereotype.Component;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName TargetObject.java
 * @Description TODO
 * @createTime 2024年08月18日 11:07:00
 */
@Component
public class TargetObject {

    public void method1() {
        System.out.println("TargetObject#method1()");
    }

    public void method2() {
        System.out.println("TargetObject#method2()");
    }
}
