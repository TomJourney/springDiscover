package com.tom.springnote.chapter31schedule.springexecutor;

import org.quartz.commonj.WorkManagerThreadExecutor;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.SyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.scheduling.concurrent.ScheduledExecutorFactoryBean;
import org.springframework.scheduling.concurrent.ScheduledExecutorTask;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.quartz.SimpleThreadPoolTaskExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName SpringTimerComponent.java
 * @Description TODO
 * @createTime 2024年10月15日 22:58:00
 */
public class SpringExecutorComponentDemo {

    public static void main(String[] args) {

        // spring 抽象 executor
        TaskExecutor taskExecutor;

        SyncTaskExecutor syncTaskExecutor;
        SimpleAsyncTaskExecutor simpleAsyncTaskExecutor;

        ThreadPoolTaskExecutor threadPoolTaskExecutor;
        SimpleThreadPoolTaskExecutor simpleThreadPoolTaskExecutor;

        ConcurrentTaskExecutor concurrentTaskExecutor;

        WorkManagerThreadExecutor workManagerThreadExecutor;
    }
}
