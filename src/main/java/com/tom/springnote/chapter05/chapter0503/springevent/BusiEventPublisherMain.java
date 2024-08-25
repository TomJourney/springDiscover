package com.tom.springnote.chapter05.chapter0503.springevent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName MethodExecutionEventPublisher.java
 * @Description 事件发布者入口
 * @createTime 2024年08月15日 15:13:00
 */
public class BusiEventPublisherMain {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("chapter05/beans0503springevent.xml");
        BusiSpringEventPublisher eventPublisher = container.getBean("busiSpringEventPublisher", BusiSpringEventPublisher.class);
        eventPublisher.monitorMethod();
    }
}
