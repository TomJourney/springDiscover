package com.tom.springnote.chapter04.t0404beanlifecycle.customBeanPostProcessor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName CustomBeanPostProcessorMain.java
 * @Description 自定义Bean后置处理器main函数入口
 * @createTime 2024年08月04日 21:14:00
 */
public class CustomBeanPostProcessorMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans0404lifecycle.xml");
        PasswordDecodeNewsListener passwordDecodeNewsListener =
                context.getBean("passwordDecodeNewsListener", PasswordDecodeNewsListener.class);
        System.out.println(passwordDecodeNewsListener.getPassword());
    }
}
