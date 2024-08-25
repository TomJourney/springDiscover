package com.tom.springnote.chapter05.chapter0503.customevent;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName SimpleMethodExecutionEventListener.java
 * @Description 事件监听器实现类
 * @createTime 2024年08月15日 15:10:00
 */
public class MethodExecutionEventListenerImpl implements IMethodExecutionEventListener {
    @Override
    public void onMethodBegin(MethodExecutionEvent event) {
        System.out.printf("方法%s执行开始\n", event.getMethodName());
    }

    @Override
    public void onMethodEnd(MethodExecutionEvent event) {
        System.out.printf("方法%s执行结束\n", event.getMethodName());
    }
}
