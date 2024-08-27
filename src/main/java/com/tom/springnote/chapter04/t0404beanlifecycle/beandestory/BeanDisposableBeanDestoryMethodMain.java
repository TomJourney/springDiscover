package com.tom.springnote.chapter04.t0404beanlifecycle.beandestory;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName BeanDisposableBeanDestoryMethodMain.java
 * @Description 配置bean实例销毁逻辑main方法入口
 * @createTime 2024年08月04日 22:12:00
 */
public class BeanDisposableBeanDestoryMethodMain {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("chapter04/beans0404lifecycle.xml");
        // 这行代码必须执行，手动注册bean对象销毁逻辑（registerShutdownHook()底层调用 Runtime.addShutdownHook()方法）
        context.registerShutdownHook();
        DBConnectionPool dBConnectionPool = context.getBean("dBConnectionPool", DBConnectionPool.class);
        System.out.println("容器关闭");
    }
}
