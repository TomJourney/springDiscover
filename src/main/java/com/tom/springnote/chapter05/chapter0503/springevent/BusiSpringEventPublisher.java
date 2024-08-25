package com.tom.springnote.chapter05.chapter0503.springevent;

import com.tom.springnote.chapter05.chapter0503.customevent.MethodExecutionStatus;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName MethodExecutionEventPublisher.java
 * @Description 事件发布器
 * @createTime 2024年08月15日 15:13:00
 */
public class BusiSpringEventPublisher implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher eventPublisher;

    public void monitorMethod() {
        BusiSpringEvent beginEvent = new BusiSpringEvent(this, "monitorMethod", MethodExecutionStatus.BEGIN);
        this.eventPublisher.publishEvent(beginEvent);
        System.out.println("执行具体业务逻辑");
        BusiSpringEvent endEvent = new BusiSpringEvent(this, "monitorMethod", MethodExecutionStatus.BEGIN);
        this.eventPublisher.publishEvent(endEvent);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}
