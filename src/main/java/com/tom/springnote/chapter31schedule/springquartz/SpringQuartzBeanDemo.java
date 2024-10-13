package com.tom.springnote.chapter31schedule.springquartz;

import org.quartz.SimpleTrigger;
import org.springframework.scheduling.quartz.*;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName SpringQuartzBean.java
 * @Description TODO
 * @createTime 2024年10月13日 19:56:00
 */
public class SpringQuartzBeanDemo {
    public static void main(String[] args) {

        SchedulerFactoryBean schedulerFactoryBean;

        JobDetailFactoryBean jobDetailFactoryBean;

        MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean;

        SimpleTriggerFactoryBean simpleTriggerFactoryBean;

        CronTriggerFactoryBean cronTriggerFactoryBean;

        long mod = SimpleTrigger.REPEAT_INDEFINITELY;

        QuartzJobBean quartzJobBean;
    }
}
