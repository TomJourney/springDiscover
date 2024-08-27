package com.tom.springnote.chapter04.t0403xmlfactorymethod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName CarFactoryBeanImplMain.java
 * @Description TODO
 * @createTime 2024年08月15日 07:58:00
 */
public class CarFactoryBeanImplMain {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("chapter04/beans0403factorymethod.xml");
        ICar car = container.getBean("electricCarFactoryBean", ICar.class);
        ICar car2 = container.getBean("electricCarFactoryBean", ICar.class);
        ICar car3 = container.getBean("electricCarFactoryBean", ICar.class);
        car.drive();
        car2.drive();
        car3.drive();
    }
}
