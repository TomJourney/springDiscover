package com.tom.springnote.chapter04.t040303xmlmethodinject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName MethodInjectNewsPersisterMain.java
 * @Description 通过 ObjectFactoryCreatingFactoryBean 实现方法注入
 * @createTime 2024年08月03日 16:37:00
 */
public class ObjectFactoryCreatingFactoryBeanNewsPersisterMain {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("chapter04/beans0403methodInject.xml");
        // 通过 ObjectFactoryCreatingFactoryBean 实现方法注入
        ObjectFactoryCreatingFactoryBeanNewsPersister objectFactoryCreatingFactoryBeanNewsPersister  =
                container.getBean("objectFactoryCreatingFactoryBeanNewsPersister", ObjectFactoryCreatingFactoryBeanNewsPersister.class);
        objectFactoryCreatingFactoryBeanNewsPersister.persistNews();
        objectFactoryCreatingFactoryBeanNewsPersister.persistNews();
        objectFactoryCreatingFactoryBeanNewsPersister.persistNews();
    }
}
