package com.tom.springnote.chapter31schedule.originquartz;

import com.tom.springnote.utils.BusiDatetimeUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName MyScheduleJob.java
 * @Description TODO
 * @createTime 2024年10月11日 21:46:00
 */
public class TomQuartzJob implements Job {
    private AtomicInteger number = new AtomicInteger(1);
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        int temp = number.getAndIncrement();
        // do sth.
        System.out.printf("number=[%d], begin, TomQuartzJob#当前时间=%s\n",  temp, BusiDatetimeUtils.getNowText());
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("number=[%d], end, TomQuartzJob#当前时间=%s\n",  temp, BusiDatetimeUtils.getNowText());
    }
}
