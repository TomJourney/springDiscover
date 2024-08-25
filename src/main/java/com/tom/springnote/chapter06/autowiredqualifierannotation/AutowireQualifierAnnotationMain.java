package com.tom.springnote.chapter06.autowiredqualifierannotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName MultiModuleLoadMain.java
 * @Description TODO
 * @createTime 2024年08月16日 06:28:00
 */
public class AutowireQualifierAnnotationMain {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("classpath:chapter06/beans0601autowirequlifierannotation.xml");
        container.getBean(AutowireQualifierBookAppService.class).book("@Autowired与@Qualifier注解的自动绑定01", "张三");
    }
}
