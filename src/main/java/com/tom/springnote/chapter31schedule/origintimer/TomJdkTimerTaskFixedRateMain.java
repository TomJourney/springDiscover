package com.tom.springnote.chapter31schedule.origintimer;

import com.tom.springnote.utils.BusiDatetimeUtils;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName JdkTimerJob.java
 * @Description TODO
 * @createTime 2024年10月13日 21:56:00
 */
public class TomJdkTimerTaskFixedRateMain {

    private static class TomTimerTask extends TimerTask {

        private AtomicInteger taskId = new AtomicInteger(0);

        @Override
        public void run() {
            int curTaskId = taskId.getAndIncrement();
            System.out.println("任务id=" + curTaskId + ", start， 当前时间=" + BusiDatetimeUtils.getNowText());
            try {
                TimeUnit.SECONDS.sleep(10); // 睡眠10秒
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("任务id=" + curTaskId + ", end， 当前时间=" + BusiDatetimeUtils.getNowText());
        }
    }

    public static void main(String[] args) {
        // 通过jdk 定时器执行调度任务
        Timer timer = new Timer();
        System.out.println("当前时间=" + BusiDatetimeUtils.getNowText());
        // 延迟5秒执行调度任务，固定频率，每3秒执行1次
        timer.scheduleAtFixedRate(new TomTimerTask(), 5000, 3000);
    }
}
