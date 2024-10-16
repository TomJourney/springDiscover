package com.tom.springnote.chapter31schedule.springexecutor;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName TomThreadPool.java
 * @Description TODO
 * @createTime 2024年10月17日 06:21:00
 */
public class TomThreadFactory implements ThreadFactory {

    private final AtomicInteger order = new AtomicInteger(1);

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread("tomThread-" + order.getAndIncrement());
        return thread;
    }
}
