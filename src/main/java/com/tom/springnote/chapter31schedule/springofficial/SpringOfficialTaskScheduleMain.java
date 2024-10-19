package com.tom.springnote.chapter31schedule.springofficial;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName TomSpringOfficialTaskScheduleMain.java
 * @Description TODO
 * @createTime 2024年10月19日 21:55:00
 */
public class SpringOfficialTaskScheduleMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext springContainer =
                new ClassPathXmlApplicationContext("chapter31schedule/spring-official-schedule.xml");
        springContainer.registerShutdownHook();
    }
}
