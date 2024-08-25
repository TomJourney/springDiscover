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
public class LoadBeanByLazyInitMain {

    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("beans0403lazyinit.xml");
        NewsProvider baiduNewsProvider = container.getBean("baiduNewsProvider", NewsProvider.class);
        System.out.println("NewsProvider bean实例化完成");
        baiduNewsProvider.getAndPersistNews();
    }
}
