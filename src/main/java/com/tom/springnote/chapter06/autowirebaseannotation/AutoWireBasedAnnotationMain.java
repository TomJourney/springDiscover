package com.tom.springnote.chapter06.autowirebaseannotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName MultiModuleLoadMain.java
 * @Description TODO
 * @createTime 2024年08月16日 06:28:00
 */
public class AutoWireBasedAnnotationMain {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("classpath:chapter06/beans0601autowirebasedannotation.xml");
        container.getBean(AnnotationBookAppService.class).book("基于注解的自动绑定房间01", "张三");
    }
}
