package com.tom.springnote.chapter06.jsr250annotaion;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName Jsr250AnnotationAutowireMain.java
 * @Description TODO
 * @createTime 2024年08月16日 16:46:00
 */
public class Jsr250AnnotationAutowireMain {
    public static void main(String[] args) {
        String[] locations = {"classpath:chapter06/beans0601autowirequlifierannotation.xml"
                , "classpath:chapter06/beans0601jsr250annotation.xml"};
        ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext(locations);
        // 若有bean销毁前执行回调，则需要注册关闭钩子回调
        container.registerShutdownHook();
        container.getBean(Jsr250AnnotationBookAppService.class).book("JSR250#@Resource注解的自动绑定01", "张三");
        System.out.println("容器关闭");
    }
}
