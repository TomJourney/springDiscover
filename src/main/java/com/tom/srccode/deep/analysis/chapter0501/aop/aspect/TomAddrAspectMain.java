package com.tom.srccode.deep.analysis.chapter0501.aop.aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tom
 * @version 1.0.0
 * @Description TODO
 * @createTime 2026年06月28日 18:01:00
 */
public class TomAddrAspectMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("/a_src_deep_analysis/chapter05/beans0701_aspect.xml");
        // 调用目标方法
        applicationContext.getBean(TomAddrBean.class).test();
    }
}
