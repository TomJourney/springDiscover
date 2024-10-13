package com.tom.springnote.chapter31.originquartzwithbuilder;

import com.tom.springnote.utils.BusiDatetimeUtils;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName TomTimeRemindJob.java
 * @Description TODO
 * @createTime 2024年10月12日 06:28:00
 */
public class TomTimeRemindJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("=========================================");
        context.getMergedJobDataMap().forEach((k,v)-> System.out.println(k + "=" + v));
        context.getJobDetail().getJobDataMap().forEach((k,v)-> System.out.println(k + "=" + v));
        System.out.println("TomTimeRemindJob now=" + BusiDatetimeUtils.getNowText());
    }
}
