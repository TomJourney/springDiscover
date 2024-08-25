package com.tom.springnote.chapter05.applicationcontext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName ApplicationContextImplMain.java
 * @Description TODO
 * @createTime 2024年08月15日 09:22:00
 */
public class ApplicationContextImplMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("");
        FileSystemXmlApplicationContext fileSystemXmlApplicationContext = new FileSystemXmlApplicationContext("");
        XmlWebApplicationContext xmlWebApplicationContext = new XmlWebApplicationContext();

        Resource resource = null;
        ResourceLoader resourceLoader = null;

        ApplicationContext applicationContext = null;
    }
}
