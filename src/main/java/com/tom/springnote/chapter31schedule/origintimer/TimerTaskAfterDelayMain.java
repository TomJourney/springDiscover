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
public class TimerTaskAfterDelayMain {

    private static class TomTimerTask extends TimerTask {
        private AtomicInteger taskId = new AtomicInteger(0);
        private String flag;

        public TomTimerTask(String flag) {
            this.flag = flag;
        }

        @Override
        public void run() {
            int curTaskId = taskId.getAndIncrement();
            System.out.printf("flag=%s, 线程id=%s, 任务id=%s, start, 当前时间=%s \n", flag, Thread.currentThread().getId(), curTaskId, BusiDatetimeUtils.getNowText());
            try {
                TimeUnit.SECONDS.sleep(10); // 睡眠10秒
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.printf("flag=%s, 线程id=%s, 任务id=%s, end, 当前时间=%s \n", flag, Thread.currentThread().getId(), curTaskId, BusiDatetimeUtils.getNowText());
        }
    }

    public static void main(String[] args) {
        // 通过jdk 定时器执行调度任务
        Timer timer = new Timer();
        System.out.println("当前时间=" + BusiDatetimeUtils.getNowText());
        // 延迟5秒执行调度任务，每3秒执行1次
        timer.schedule(new TomTimerTask("A"), 5000, 3000);
        timer.schedule(new TomTimerTask("B"), 5000, 3000);
        System.out.println("after timer.schedule()新增调度任务之后");
    }
}
