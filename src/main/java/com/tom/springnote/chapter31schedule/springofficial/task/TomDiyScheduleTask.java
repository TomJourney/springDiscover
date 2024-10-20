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
public class TomDiyScheduleTask {

    @Scheduled(fixedRate = 2000, initialDelay = 3000)
    public void diySchedule() {
        System.out.printf("TomDiyTask#diySchedule(): 线程id=%s 当前时间=%s \n", Thread.currentThread().getId(), BusiDatetimeUtils.getNowText());
        try {
//            TimeUnit.SECONDS.sleep(5);
            TimeUnit.SECONDS.sleep(1); // 睡眠1s
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void diySchedule2() {
        System.out.printf("TomDiyTask#diySchedule2(): 线程id=%s 当前时间=%s \n", Thread.currentThread().getId(), BusiDatetimeUtils.getNowText());
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
