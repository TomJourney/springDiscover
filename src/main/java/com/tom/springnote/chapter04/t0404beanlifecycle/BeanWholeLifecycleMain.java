package com.tom.springnote.chapter04.t0404beanlifecycle;

import com.tom.springnote.chapter04.t0404beanlifecycle.beandestory.DBConnectionPool;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName BeanLifecycleMain.java
 * @Description bean生命周期main函数入口
 * @createTime 2024年08月04日 22:24:00
 */
public class BeanWholeLifecycleMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans0404wholelifecycle.xml");
        // 若需要注册bean销毁前回调方法，必须执行registerShutdownHook()进行注册
        context.registerShutdownHook();
        DBConnectionPool dbConnectionPool = context.getBean("dbConnectionPool", DBConnectionPool.class);
        System.out.println(dbConnectionPool.getPassword());
        System.out.println("容器关闭");
    }
}
