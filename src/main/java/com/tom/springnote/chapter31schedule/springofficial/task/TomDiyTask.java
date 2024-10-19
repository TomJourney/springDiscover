package com.tom.springnote.chapter31schedule.springofficial.task;

import com.tom.springnote.utils.BusiDatetimeUtils;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.TimeUnit;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName TomSpringScheduleTask.java
 * @Description TODO
 * @createTime 2024年10月19日 22:09:00
 */
public class TomDiyTask {

    @Scheduled(fixedRate = 2000, initialDelay = 3000)
    public void schedule() {
        System.out.printf("TomDiyTask#schedule(): 线程id=%s 当前时间=%s \n", Thread.currentThread().getId(), BusiDatetimeUtils.getNowText());
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void asyncDoBusi() {
        System.out.printf("TomDiyTask#asyncDoBusi(): 线程id=%s 当前时间=%s \n", Thread.currentThread().getId(), BusiDatetimeUtils.getNowText());
    }
}
