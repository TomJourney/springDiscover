package com.tom.springnote.chapter04.t0404;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName PropertyPlaceholderConfigurerMain.java
 * @Description 属性占位符配置器-后置处理器
 * @createTime 2024年08月03日 17:57:00
 */
public class PropertySourcesPlaceholderConfigurerMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("chapter04/beans0404.xml");
        BasicDataSource dataSource = context.getBean("dataSource", BasicDataSource.class);
        System.out.println(dataSource.getUrl());
        System.out.println(dataSource.getUserName());
        System.out.println(dataSource.getDriverClassName());
    }
}
