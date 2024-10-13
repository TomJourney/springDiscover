package com.tom.springnote.chapter31schedule.springquartz;

import com.tom.springnote.utils.BusiDatetimeUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName SpringScheduleJob.java
 * @Description TODO
 * @createTime 2024年10月13日 19:54:00
 */
public class TomSpringQuartzJobBean extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("TomSpringQuartzJobBean #当前时间=" + BusiDatetimeUtils.getNowText());
    }
}
