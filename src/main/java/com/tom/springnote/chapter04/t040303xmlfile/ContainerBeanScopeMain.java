package com.tom.springnote.chapter04.t040303xmlfile;

import com.tom.springnote.chapter04.t0401.NewsProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author TomBrother
 * @version 1.0.0
 * @Description 容器bean的scope存活时间
 * @createTime 2024年08月01日
 */
public class ContainerBeanScopeMain {

    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("beans0403scope.xml");
        System.out.println(container.getBean("singletonNewsProvider", NewsProvider.class));
        System.out.println(container.getBean("singletonNewsProvider", NewsProvider.class));
        System.out.println(container.getBean("prototypeNewsProvider", NewsProvider.class));
        System.out.println(container.getBean("prototypeNewsProvider", NewsProvider.class));
    }
}
