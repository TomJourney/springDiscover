package com.tom.springnote.chapter31schedule.springofficial.quartz;

import com.tom.springnote.utils.BusiDatetimeUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.concurrent.TimeUnit;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName DiyQuartzJob.java
 * @Description TODO
 * @createTime 2024年10月20日 10:55:00
 */
public class DiyQuartzJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.printf("DiyQuartzJob#executeInternal(): 线程id=%s 当前时间=%s \n", Thread.currentThread().getId(), BusiDatetimeUtils.getNowText());
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
