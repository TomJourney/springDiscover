package com.tom.springnote.chapter31.originquartz;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.quartz.impl.triggers.SimpleTriggerImpl;

import java.text.ParseException;
import java.util.Date;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName TomTrigger.java
 * @Description TODO
 * @createTime 2024年10月11日 21:59:00
 */
public class TomQuartzJobMain {
    public static void main(String[] args) throws Exception {
        executeScheduleJob();
    }

    private static void executeScheduleJob() throws ParseException, SchedulerException {
        // 新建触发器
        SimpleTriggerImpl simpleTrigger =
                new SimpleTriggerImpl(
                        "tomSimpleTrigger", "tomSimpleTriggerGroup", new Date()
                        , null, SimpleTriggerImpl.REPEAT_INDEFINITELY, 5000); // 每隔5秒执行1次
        CronTriggerImpl cronTrigger = new CronTriggerImpl("tomSimpleTrigger", "tomSimpleTriggerGroup", "*/5 * * * * ?");

        // 新建调度器
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();

        // 新建调度任务详情
        JobDetailImpl tomJobDetail = new JobDetailImpl("tomJobDetail", TomQuartzJob.class);

        // 新增调度任务（这里是新增，并没有执行，执行由触发器来负责）
//        scheduler.scheduleJob(tomJobDetail, simpleTrigger);
        scheduler.scheduleJob(tomJobDetail, cronTrigger);
    }
}
