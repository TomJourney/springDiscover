package com.tom.springnote.chapter31schedule.originquartzwithbuilder;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName TomTimeRemindJob.java
 * @Description TODO
 * @createTime 2024年10月12日 06:28:00
 */
public class TomTimeRemindJobMain {

    public static void main(String[] args) throws SchedulerException {
        // 创建调度器实例
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        // 开启调度器
        scheduler.start();
        // 执行调度作业
        executeScheduleJob(scheduler);
        // 关闭调度器
//        scheduler.shutdown();
    }

    private static void executeScheduleJob(Scheduler scheduler) throws SchedulerException {
        // 创建JobDetail，并与TomTimeRemindJob 绑定
        JobDetail jobDetail = JobBuilder.newJob(TomTimeRemindJob.class)
                .withIdentity("tomJob01", "tomJob01Group")
                .build();

        // 立即触发作业执行，每5秒重复一次
        SimpleTrigger simpleTrigger = TriggerBuilder.newTrigger()
                .withIdentity("tomTrigger01", "tomTrigger01Group")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever())
                .build();

        // 告诉quartz使用我们的触发器调度作业
        scheduler.scheduleJob(jobDetail, simpleTrigger);
    }
}
