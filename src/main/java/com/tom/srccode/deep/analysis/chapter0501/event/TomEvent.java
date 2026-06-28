package com.tom.srccode.deep.analysis.chapter0501.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;

/**
 * @author tom
 * @version 1.0.0
 * @Description tom事件
 * @createTime 2026年06月28日 15:47:00
 */
@Slf4j
public class TomEvent extends ApplicationEvent {

    private String msg;

    public TomEvent(Object source) {
        super(source);
    }

    public TomEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public void print() {
      log.info("msg = {}", msg);
    }
}
