package com.tom.springnote.chapter31schedule.origintimer;

import com.tom.springnote.utils.BusiDatetimeUtils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TimerTaskAtFixedRateMain {

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
        // 【以固定频率执行】在5秒之后的时间点（给定时间）执行， 以固定频率每3秒执行1次，第n+1个任务无需等待第n个任务执行完成，而是到点自动执行
        timer.scheduleAtFixedRate(new TomTimerTask("A"), timeAfterSecond(5), 3000);
        System.out.println("after timer.schedule()新增调度任务之后");
    }

    private static Date timeAfterSecond(long afterSecond) {
        LocalDateTime timeAfterSecond = LocalDateTime.now().plusSeconds(afterSecond);
        return Date.from(timeAfterSecond.atZone(ZoneId.systemDefault()).toInstant());
    }
}
