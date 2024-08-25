package com.tom.springnote.chapter04.t040303xmlfactorybean;

import com.tom.springnote.chapter04.t0401.NewsDto;
import com.tom.springnote.chapter04.t0401.NewsProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author TomBrother
 * @version 1.0.0
 * @ClassName NewsDtoStaticfactoryMain.java
 * @Description 静态工厂实例化bean
 * @createTime 2024年08月03日
 */
public class NewsDtoStaticfactoryMain {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("beans0403factorybean.xml");
        System.out.println(container.getBean(NewsDto.class));
        System.out.println(container.getBean(NewsDto.class));
        System.out.println(container.getBean(NewsDto.class));
    }
}
