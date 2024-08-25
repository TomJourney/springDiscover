package com.tom.springnote.chapter08proxypattern.dynamicbytegen;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName DynamicByteGenMain.java
 * @Description 动态字节码生成main
 * @createTime 2024年08月17日 09:26:00
 */
public class CglibDynamicProxyMain {
    public static void main(String[] args) {
        // 传入target
        BusiTarget target = new BusiTarget();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(new CglibMethodInterceptorImpl(target));
        BusiTarget dynamicByteProxyTaskSender = (BusiTarget) enhancer.create();
        dynamicByteProxyTaskSender.send1("您有1个待办任务需要处理", "task001");

        System.out.println();
        dynamicByteProxyTaskSender.send2("您有2个待办任务需要处理", "task002");
    }
}
