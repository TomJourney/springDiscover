package com.tom.springnote.chapter04.t040203annotation;

import com.tom.springnote.chapter04.t0401.NewsProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author TomBrother
 * @version 1.0.0
 * @ClassName LoadBeanFactoryByXmlFileMain.java
 * @Description 注解方式加载bean
 * @createTime 2024年08月01日
 */
public class LoadBeanFactoryByAnnotationMain {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("chapter04/beans-component-scan-0401.xml");
        NewsProvider baiduNewsProvider2 = container.getBean(NewsProvider.class);
        baiduNewsProvider2.getAndPersistNews();
    }
}
