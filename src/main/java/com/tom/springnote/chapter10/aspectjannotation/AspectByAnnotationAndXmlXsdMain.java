package com.tom.springnote.chapter10.aspectjannotation;

import com.tom.springnote.common.aop.BusiMessage;
import com.tom.springnote.common.aop.ManNoItfCallTask;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName AspectjAnnotationMain.java
 * @Description TODO
 * @createTime 2024年08月23日 06:42:00
 */
public class AspectByAnnotationAndXmlXsdMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext container =
                new ClassPathXmlApplicationContext("chapter10/beans10aspectannotationxsd.xml");

        // 获取代理对象
        Object proxy = container.getBean("target");
        ((ManNoItfCallTask) proxy).call(BusiMessage.build("任务编号001", "您有待办任务需要处理"));
        System.out.println(proxy.getClass());
    }
}
