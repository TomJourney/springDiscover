package com.tom.springnote.chapter04.t040303xmlfile;

import com.tom.springnote.chapter04.t0401.NewsProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author TomBrother
 * @version 1.0.0
 * @Description 自动装配注入
 * @createTime 2024年08月01日
 */
public class AutowireInjectMain {

    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("chapter04/beans0403autowire.xml");
        NewsProvider baiduNewsProvider = container.getBean("baiduNewsProvider", NewsProvider.class);
        baiduNewsProvider.getAndPersistNews();

        container.getBean("baiduNewsProvider2", NewsProvider.class).getAndPersistNews();

        container.getBean("baiduNewsProvider3", NewsProvider.class).getAndPersistNews();
    }
}
