package com.tom.springnote.chapter31schedule.origintimer.schedulethreadpool;

import com.tom.springnote.utils.BusiDatetimeUtils;

import java.util.Objects;
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
public class RepeatableTaskExecuteBySchedulerThreadPoolThrowExceptionMain {
    static class BusiTask implements Runnable {
        private String flag;
        public BusiTask(String flag) {
            this.flag = flag;
        }
        @Override
        public void run() {
            System.out.printf("flag=%s, 线程id=%s 当前时间=%s \n", flag, Thread.currentThread().getId(), BusiDatetimeUtils.getNowText());
            if (Objects.equals("exception", flag)) {
                throw new RuntimeException("mock runtime exception");
            }
        }
    }
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        // 重复任务，间隔2s执行1次
        scheduledExecutorService.scheduleAtFixedRate(new BusiTask("exception"), 0, 2000, TimeUnit.MILLISECONDS);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // 第2次添加任务
        scheduledExecutorService.scheduleAtFixedRate(new BusiTask("zhangsan"), 0, 2000, TimeUnit.MILLISECONDS);
    }
}
