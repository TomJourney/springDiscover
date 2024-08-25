package com.tom.springnote.chapter09.autoproxy.defaultadvisorautoproxycreator;

import com.tom.springnote.common.aop.BusiMessage;
import com.tom.springnote.common.aop.ManNoItfCallTask;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName DefaultAdvisorAutoProxyCreatorMain.java
 * @Description TODO
 * @createTime 2024年08月22日 15:22:00
 */
public class DefaultAdvisorAutoProxyCreatorMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext container =
                new ClassPathXmlApplicationContext("chapter09/beans09defaultadvisorautoproxycreator.xml");
        // 获取 DefaultAdvisorAutoProxyCreator 自动织入的代理对象
        ManNoItfCallTask proxy1 = (ManNoItfCallTask) container.getBean("target1");
        ManNoItfCallTask proxy2 = (ManNoItfCallTask) container.getBean("target2");

        // 调用代理对象方法
        proxy1.call(BusiMessage.build("任务编号001" ,"您有待办任务需要处理"));
        System.out.println("\n=== 我是分割线 ===");
        proxy2.call(BusiMessage.build("任务编号002" ,"您有待办任务需要处理"));
    }
}
