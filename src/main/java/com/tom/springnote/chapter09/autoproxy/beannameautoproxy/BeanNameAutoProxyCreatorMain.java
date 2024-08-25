package com.tom.springnote.chapter09.autoproxy.beannameautoproxy;

import com.tom.springnote.common.aop.BusiMessage;
import com.tom.springnote.common.aop.ManNoItfCallTask;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLOutput;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName BeanNameAutoProxyCreatorMain.java
 * @Description TODO
 * @createTime 2024年08月22日 15:06:00
 */
public class BeanNameAutoProxyCreatorMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext container =
                new ClassPathXmlApplicationContext("chapter09/beans09beannameautoproxycreator.xml");

        // 获取 BeanNameAutoProxyCreator 自动织入的代理对象
        ManNoItfCallTask target1 = container.getBean("target1", ManNoItfCallTask.class);
        ManNoItfCallTask target2 = container.getBean("target2", ManNoItfCallTask.class);

        // 调用代理对象方法
        target1.call(BusiMessage.build("任务001", "您有待办任务需要处理"));
        System.out.println("\n=== 我是分割线 ===");
        target2.call(BusiMessage.build("任务002", "您有待办任务需要处理"));
    }
}
