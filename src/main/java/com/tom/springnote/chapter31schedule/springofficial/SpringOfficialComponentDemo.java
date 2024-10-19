package com.tom.springnote.chapter31schedule.springofficial;

import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.SyncTaskExecutor;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.*;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.PeriodicTrigger;

import java.util.concurrent.Flow;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName SpringOfficialComponentDemo.java
 * @Description TODO
 * @createTime 2024年10月18日 21:17:00
 */
public class SpringOfficialComponentDemo {

    DefaultManagedTaskScheduler defaultManagedTaskScheduler;

    ThreadPoolTaskScheduler threadPoolTaskScheduler;

    ConcurrentTaskScheduler concurrentTaskScheduler;

    SimpleAsyncTaskScheduler simpleAsyncTaskScheduler;


    public static ThreadPoolTaskScheduler buildThreadPoolTaskScheduler() {
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.initialize();
        return threadPoolTaskScheduler;
    }

}
