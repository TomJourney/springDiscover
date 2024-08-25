package com.tom.springnote.chapter05.chapter0503.customevent;

import java.util.EventListener;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName MethodExecutionEventListener.java
 * @Description 事件监听器
 * @createTime 2024年08月15日 15:09:00
 */
public interface IMethodExecutionEventListener extends EventListener {

    void onMethodBegin(MethodExecutionEvent event);
    void onMethodEnd(MethodExecutionEvent event);
}
