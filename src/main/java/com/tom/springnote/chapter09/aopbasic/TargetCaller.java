package com.tom.springnote.chapter09.aopbasic;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName TargetCaller.java
 * @Description TODO
 * @createTime 2024年08月18日 11:03:00
 */
public class TargetCaller {

    private TargetObject targetObject;

    @Autowired
    public TargetCaller(TargetObject targetObject) {
        this.targetObject = targetObject;
    } 
    public void upstreamMethod1() {
        targetObject.method1();
    }

    public void upstreamMethod2() {
        targetObject.method1();
    }
}
