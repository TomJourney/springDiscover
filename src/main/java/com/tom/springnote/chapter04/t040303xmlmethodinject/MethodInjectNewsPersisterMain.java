package com.tom.springnote.chapter04.t040303xmlmethodinject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName MethodInjectNewsPersisterMain.java
 * @Description TODO
 * @createTime 2024年08月03日 16:37:00
 */
public class MethodInjectNewsPersisterMain {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("chapter04/beans0403methodInject.xml");
        container.getBean("methodInjectNewsPersister", MethodInjectNewsPersister.class).persistNews();
        container.getBean("methodInjectNewsPersister", MethodInjectNewsPersister.class).persistNews();
        container.getBean("methodInjectNewsPersister", MethodInjectNewsPersister.class).persistNews();

        // 实现 BeanFactoryAware
        MethodInjectNewsPersister beanFactoryAwareNewsPersister =
                container.getBean("beanFactoryAwareNewsPersister", MethodInjectNewsPersister.class);
        beanFactoryAwareNewsPersister.persistNews();
        beanFactoryAwareNewsPersister.persistNews();
        beanFactoryAwareNewsPersister.persistNews();
    }
}
