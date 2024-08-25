package com.tom.springnote.chapter12;

import com.tom.springnote.chapter12.target.NestedCallAspect;
import com.tom.springnote.chapter12.target.NestedCallTarget;
import com.tom.springnote.chapter12.target.NestedCallTargetWithHoldProxy;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName NestedCallMain.java
 * @Description TODO
 * @createTime 2024年08月24日 11:18:00
 */
public class NestedCallTargetWithHoldProxyMain {
    public static void main(String[] args) {
        NestedCallTargetWithHoldProxy target = new NestedCallTargetWithHoldProxy();
        AspectJProxyFactory weaver = new AspectJProxyFactory(target);
        weaver.setExposeProxy(true);
        weaver.addAspect(NestedCallAspect.class);

        // 获取代理对象
        Object proxy = weaver.getProxy();
        ((NestedCallTargetWithHoldProxy) proxy).method1();
    }
}
