package com.tom.springnote.chapter05.chapter0503.customevent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName MethodExecutionEventPublisher.java
 * @Description 事件发布器
 * @createTime 2024年08月15日 15:13:00
 */
public class MethodExecutionEventPublisher {
    private List<IMethodExecutionEventListener> listenerList = new ArrayList<>();

    public void monitorMethod() {
        MethodExecutionEvent event = new MethodExecutionEvent(this, "monitorMethod");
        publishEvent(MethodExecutionStatus.BEGIN, event);
        System.out.println("执行具体业务逻辑");
        publishEvent(MethodExecutionStatus.END, event);
    }

    protected void publishEvent(MethodExecutionStatus status, MethodExecutionEvent event) {
        listenerList.forEach(listener -> {
            if (status.ifBegin()) {
                listener.onMethodBegin(event);
            } else {
                listener.onMethodEnd(event);
            }
        });
    }

    public void addListener(IMethodExecutionEventListener listener) {
        listenerList.add(listener);
    }
}
