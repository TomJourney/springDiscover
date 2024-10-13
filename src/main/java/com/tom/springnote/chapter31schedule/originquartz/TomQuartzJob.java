package com.tom.springnote.chapter31schedule.originquartz;

import com.tom.springnote.utils.BusiDatetimeUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName MyScheduleJob.java
 * @Description TODO
 * @createTime 2024年10月11日 21:46:00
 */
public class TomQuartzJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        // do sth.
        System.out.println("TomQuartzJob#当前时间=" + BusiDatetimeUtils.getNowText());
    }
}
