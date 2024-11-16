package com.tom.springsourcecode;

import com.tom.springsourcecode.config.AppConfig00;
import com.tom.springsourcecode.config.AppConfig02;
import com.tom.springsourcecode.service.HelloService;
import com.tom.springsourcecode.service.HelloService02;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName BasedJavaContainerMain.java
 * @Description TODO
 * @createTime 2024年10月23日 06:37:00
 */
public class JavaBasedContainerUsingSeveralJavaConfigMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        System.out.println("before register()");
        context.register(AppConfig00.class, AppConfig02.class);
        System.out.println("after register()");
        context.refresh();
        System.out.println("after refresh()");
        context.getBean(HelloService.class).sayHello("Musk");
        context.getBean(HelloService02.class).sayHello("Trump");
    }
}
