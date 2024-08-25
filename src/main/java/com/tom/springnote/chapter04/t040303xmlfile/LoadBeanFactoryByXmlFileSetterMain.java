package com.tom.springnote.chapter04.t040303xmlfile;

import com.tom.springnote.chapter04.t0401.NewsProvider;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author TomBrother
 * @version 1.0.0
 * @ClassName LoadBeanFactoryByXmlFileMain.java
 * @Description xml配置格式通过setter注入
 * @createTime 2024年08月01日
 */
public class LoadBeanFactoryByXmlFileSetterMain {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("classpath:beans0403.xml");
        NewsProvider baiduNewsProvider = container.getBean("baiduNewsProvider2", NewsProvider.class);
        baiduNewsProvider.getAndPersistNews();
    }
}
