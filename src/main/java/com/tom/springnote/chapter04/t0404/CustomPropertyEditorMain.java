package com.tom.springnote.chapter04.t0404;

import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName CustomerPropertyEditorMain.java
 * @Description 自定义属性编辑器
 * @createTime 2024年08月04日 07:37:00
 */
public class CustomPropertyEditorMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans0404.xml");
        System.out.println(context.getBean("customDateDto", CustomDateDto.class));
    }
}
