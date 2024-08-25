package com.tom.springnote.chapter05.chapter0503.springevent;

import org.springframework.context.ApplicationListener;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName SimpleMethodExecutionEventListener.java
 * @Description 事件监听器实现类
 * @createTime 2024年08月15日 15:10:00
 */
public class BusiSpringEventListenerImpl implements ApplicationListener<BusiSpringEvent> {

    @Override
    public void onApplicationEvent(BusiSpringEvent event) {
        String nowText = BusiDatetimeUtils.timestampToDatetime(event.getTimestamp());
        if (event.getStatus().ifBegin()) {
            System.out.printf("%s 方法%s执行开始\n", nowText, event.getMethodName());
        } else {
            System.out.printf("%s 方法%s执行结束\n", nowText, event.getMethodName());
        }
    }
    @Override
    public boolean supportsAsyncExecution() {
        return ApplicationListener.super.supportsAsyncExecution();
    }
}
