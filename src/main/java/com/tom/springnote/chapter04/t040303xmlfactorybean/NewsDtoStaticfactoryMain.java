package com.tom.springnote.chapter04.t040303xmlfactorybean;

import com.tom.springnote.chapter04.t0401.NewsDto;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author TomBrother
 * @version 1.0.0
 * @ClassName NewsDtoStaticfactoryMain.java
 * @Description 静态工厂实例化bean
 * @createTime 2024年08月03日
 */
public class NewsDtoStaticfactoryMain {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("chapter04/beans0403factorybean.xml");
        System.out.println(container.getBean(NewsDto.class));
        System.out.println(container.getBean(NewsDto.class));
        System.out.println(container.getBean(NewsDto.class));
    }
}
