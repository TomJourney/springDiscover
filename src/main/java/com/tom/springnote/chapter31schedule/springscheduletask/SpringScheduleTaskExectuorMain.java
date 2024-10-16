package com.tom.springnote.chapter31schedule.springscheduletask;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName SpringScheduleTaskExectuorMain.java
 * @Description TODO
 * @createTime 2024年10月17日 06:53:00
 */
public class SpringScheduleTaskExectuorMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext springContext =
                new ClassPathXmlApplicationContext("chapter31schedule/spring-schedulethreadpool.xml");
        ((AbstractApplicationContext) springContext).registerShutdownHook();
    }
}
