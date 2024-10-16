package com.tom.springnote.chapter31schedule.origintimer.schedulethreadpool;

import com.tom.springnote.utils.BusiDatetimeUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName RepeatableTaskExecuteBySchedulerThreadPoolMain.java
 * @Description TODO
 * @createTime 2024年10月16日 22:00:00
 */
public class RepeatableTaskExecuteBySchedulerThreadPoolMain {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.printf("线程id=%s 当前时间=%s \n", Thread.currentThread().getId(), BusiDatetimeUtils.getNowText());
            }
        };
        // 重复任务，间隔2s执行1次
        scheduledExecutorService.scheduleAtFixedRate(task, 0, 2000, TimeUnit.MILLISECONDS);
    }
}
