package com.tom.springnote.chapter31schedule.springofficial.task;

import com.tom.springnote.utils.BusiDatetimeUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.TimeUnit;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName TomSpringScheduleTask.java
 * @Description TODO
 * @createTime 2024年10月19日 22:09:00
 */
public class TomDiyAsyncTask {

    @Async("myExecutor")
    public void asyncDoBusi() {
        System.out.printf("TomDiyAsyncTask#asyncDoBusi(): 线程id=%s 线程name=%s 当前时间=%s \n",
                Thread.currentThread().getId(),
                Thread.currentThread().getName(),
                BusiDatetimeUtils.getNowText());
    }
}
