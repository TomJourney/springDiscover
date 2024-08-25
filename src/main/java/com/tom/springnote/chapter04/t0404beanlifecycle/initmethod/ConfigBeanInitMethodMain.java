package com.tom.springnote.chapter04.t0404beanlifecycle.initmethod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName ConfigBeanInitMethodMain.java
 * @Description 配置bean的 init-method 指定对象初始化操作
 * @createTime 2024年08月04日 21:51:00
 */
public class ConfigBeanInitMethodMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans0404lifecycle.xml");
        System.out.println(context.getBean("initMethodInitializingCache", InitMethodInitializingCache.class).getCache());
    }
}
