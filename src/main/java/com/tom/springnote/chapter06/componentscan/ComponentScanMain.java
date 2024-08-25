package com.tom.springnote.chapter06.componentscan;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName ComponentScanMain.java
 * @Description TODO
 * @createTime 2024年08月16日 19:18:00
 */
public class ComponentScanMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("classpath:chapter06/beans0601componentscan.xml");
        container.getBean(ComponentScanAppService.class).scan();
    }
}
