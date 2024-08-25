package com.tom.springnote.chapter12;

import com.tom.springnote.chapter12.target.NestedCallTarget;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName NestedCallMain.java
 * @Description TODO
 * @createTime 2024年08月24日 11:18:00
 */
public class NestedCallMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("chapter12/beans12nestedcall.xml");

        // 获取代理对象
        Object proxy = container.getBean("nestedCallTarget");
        ((NestedCallTarget) proxy).method1();
    }
}
