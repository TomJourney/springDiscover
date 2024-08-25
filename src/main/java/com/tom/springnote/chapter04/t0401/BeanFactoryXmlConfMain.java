package com.tom.springnote.chapter04.t0401;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author TomBrother
 * @version 1.0.0
 * @ClassName BeanFactoryXmlConfMain.java
 * @Description BeanFactory的xml配置方式
 * @createTime 2024年08月01日
 */
public class BeanFactoryXmlConfMain {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("beans0401.xml");
        NewsProvider baiduNewsProvider = (NewsProvider) container.getBean("baiduNewsProvider");
        NewsProvider baiduNewsProvider2 = container.getBean("baiduNewsProvider", NewsProvider.class);
        baiduNewsProvider2.getAndPersistNews();
    }
}
