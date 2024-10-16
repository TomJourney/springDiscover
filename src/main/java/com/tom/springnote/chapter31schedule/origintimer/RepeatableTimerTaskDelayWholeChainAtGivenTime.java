package com.tom.springnote.chapter31schedule.origintimer;

import com.tom.springnote.utils.BusiDatetimeUtils;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName TimerTaskOnceExecuteAfterDelayMain.java
 * @Description TODO
 * @createTime 2024年10月16日 06:38:00
 */
public class RepeatableTimerTaskDelayWholeChainAtGivenTime {
    public static void main(String[] args) {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.printf("线程id=%s 当前时间=%s \n", Thread.currentThread().getId(), BusiDatetimeUtils.getNowText());
                try {
                    TimeUnit.SECONDS.sleep(5); // 模拟单个任务执行耗时5秒
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        // 通过jdk 定时器执行调度任务
        Timer timer = new Timer();
        System.out.println("当前时间=" + BusiDatetimeUtils.getNowText());
        // 在给定时间点（当前时间加5秒的时间）执行调度任务，间隔2s重复执行
        timer.schedule(timerTask, BusiDatetimeUtils.timeAfterSecond(1), 2000);
        System.out.println("after timer.schedule()新增调度任务之后");

        try {
            TimeUnit.SECONDS.sleep(30); // 延迟30秒，等待执行重复调度任务
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // 取消调度器执行(主线程结束)
        timer.cancel();
        System.out.println("主线程结束， 当前时间=" + BusiDatetimeUtils.getNowText());
    }
}
