package com.tom.srccode.deep.analysis.chapter0501.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author tom
 * @version 1.0.0
 * @Description tom事件监听器
 * @createTime 2026年06月28日 15:49:00
 */
public class TomEventListener implements ApplicationListener<TomEvent> {
    @Override
    public void onApplicationEvent(TomEvent tomEvent) {
        tomEvent.print();
    }
}
