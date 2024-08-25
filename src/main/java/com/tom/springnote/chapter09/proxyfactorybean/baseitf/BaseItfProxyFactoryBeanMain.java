package com.tom.springnote.chapter09.proxyfactorybean.baseitf;

import com.tom.springnote.common.aop.BusiMessage;
import com.tom.springnote.common.aop.ICallTask;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName ProxyFactoryBeanMain.java
 * @Description TODO
 * @createTime 2024年08月20日 09:53:00
 */
public class BaseItfProxyFactoryBeanMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext container =
                new ClassPathXmlApplicationContext("chapter09/beans09proxyfactorybeanbasedItf.xml");
        ICallTask callTask = (ICallTask) container.getBean("robotCallTaskImplProxy");
        callTask.call(BusiMessage.build("任务编号01", "您有待办任务需要处理"));

        // 验证单例还是原型bean
        System.out.println("\n=== 验证单例还是原型bean ===");
        System.out.println(container.getBean("robotCallTaskImplProxy"));
        System.out.println(container.getBean("robotCallTaskImplProxy"));

        // 验证是JDK动态代理还是CGLIB动态代理
        System.out.println("\n=== 验证是JDK动态代理还是CGLIB动态代理 ===");
        System.out.println(callTask.getClass());
    }
}
