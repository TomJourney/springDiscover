package com.tom.springnote.chapter04.t0403xmlfactorymethod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName CarStaticFactoryMain.java
 * @Description TODO
 * @createTime 2024年08月15日 07:25:00
 */
public class CarStaticFactoryMain {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("beans0403factorymethod.xml");
        ICar electricCar = container.getBean("electricCar", ICar.class);
        ICar electricCar2 = container.getBean("electricCar", ICar.class);
        ICar electricCar3 = container.getBean("electricCar", ICar.class);
        electricCar.drive();
        electricCar2.drive();
        electricCar3.drive();
    }
}
