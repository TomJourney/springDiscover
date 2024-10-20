package com.tom.springnote.chapter31schedule.springscheduletask;

import com.tom.springnote.utils.BusiDatetimeUtils;

import java.util.concurrent.TimeUnit;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName TomScheduledExecutorTask.java
 * @Description TODO
 * @createTime 2024年10月17日 06:35:00
 */
public class TomScheduledTask implements Runnable {
    @Override
    public void run() {
        System.out.printf("开始： 线程id=%s 当前时间=%s \n", Thread.currentThread().getId(), BusiDatetimeUtils.getNowText());
        try {
            TimeUnit.SECONDS.sleep(4); // 睡眠4s 模拟业务逻辑处理耗时4s
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("结束： 线程id=%s 当前时间=%s \n", Thread.currentThread().getId(), BusiDatetimeUtils.getNowText());
    }
}
