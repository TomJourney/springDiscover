package com.tom.springnote.chapter04.t040303xmlfile;

import com.tom.springnote.chapter04.t0401.NewsProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author TomBrother
 * @version 1.0.0
 * @ClassName InjectCollectionByXmlFileSetterMain.java
 * @Description 注入容器
 * @createTime 2024年08月01日
 */
public class InjectCollectionByXmlFileSetterMain {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("classpath:beans0403collection.xml");
        NewsProvider baiduNewsProvider = container.getBean("baiduNewsProvider2", NewsProvider.class);
        baiduNewsProvider.getAndPersistNews();
    }
}
