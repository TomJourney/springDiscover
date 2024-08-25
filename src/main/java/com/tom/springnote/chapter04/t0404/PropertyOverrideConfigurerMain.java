package com.tom.springnote.chapter04.t0404;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName PropertyPlaceholderConfigurerMain.java
 * @Description 属性重写配置器后置处理器
 * @createTime 2024年08月03日 17:57:00
 */
public class PropertyOverrideConfigurerMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans0404.xml");
        BasicDataSource dataSource = context.getBean("dataSource", BasicDataSource.class);
        System.out.println(dataSource.getUrl());
        System.out.println(dataSource.getUserName());
        System.out.println(dataSource.getDriverClassName());
    }
}
