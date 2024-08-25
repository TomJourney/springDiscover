package com.tom.springnote.chapter09.targetsource;

import com.tom.springnote.common.aop.BusiMessage;
import com.tom.springnote.common.aop.ManNoItfCallTask;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName singletontargetsource.java
 * @Description TODO
 * @createTime 2024年08月22日 17:31:00
 */
public class PrototypeTargetSourceMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext container =
                new ClassPathXmlApplicationContext("chapter09targetsource/beans09prototypetargetsource.xml");

        // 获取代理对象
        Object proxy = container.getBean("prototypeTargetSourceProxy");
        ((ManNoItfCallTask)proxy).call(BusiMessage.build("任务编号001", "您有待办任务需要处理"));

        System.out.println("\n === 我是分割线，判断是否原型bean ===");
        System.out.println(container.getBean("prototypeTargetSourceProxy"));
        System.out.println("\n === 我是分割线，第2次获取prototypeTargetSourceProxy bean ");
        System.out.println(container.getBean("prototypeTargetSourceProxy"));
    }
}
