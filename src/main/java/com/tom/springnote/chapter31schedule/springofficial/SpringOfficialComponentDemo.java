package com.tom.springnote.chapter31schedule.springofficial;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.support.CronTrigger;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName SpringOfficialComponentDemo.java
 * @Description TODO
 * @createTime 2024年10月18日 21:17:00
 */
public class SpringOfficialComponentDemo {

    TaskScheduler taskScheduler;

    Trigger trigger;

    TriggerContext triggerContext;

    CronTrigger cronTrigger;
}
