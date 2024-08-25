package com.tom.springnote.chapter05.chapter0503.customevent;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName MethodExecutionEventPublisher.java
 * @Description 事件发布器
 * @createTime 2024年08月15日 15:13:00
 */
public class MethodExecutionEventPublisherMain {
    public static void main(String[] args) {
        MethodExecutionEventPublisher eventPublisher = new MethodExecutionEventPublisher();
        eventPublisher.addListener(new MethodExecutionEventListenerImpl());
        eventPublisher.monitorMethod();
    }
}
