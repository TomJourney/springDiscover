package com.tom.springnote.chapter31schedule.springquartz;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName SpringScheduleJob.java
 * @Description TODO
 * @createTime 2024年10月13日 19:54:00
 */
public class TomSpringQuartzJobBeanMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext("chapter31schedule/springquartz.xml");
        ((AbstractApplicationContext) springContext).registerShutdownHook();
    }
}
