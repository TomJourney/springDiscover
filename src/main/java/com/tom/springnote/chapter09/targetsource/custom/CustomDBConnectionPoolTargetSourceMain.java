package com.tom.springnote.chapter09.targetsource.custom;

import com.tom.springnote.common.aop.BusiMessage;
import com.tom.springnote.common.aop.ManNoItfCallTask;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName singletontargetsource.java
 * @Description TODO
 * @createTime 2024年08月22日 17:31:00
 */
public class CustomDBConnectionPoolTargetSourceMain {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTargetSource(new CustomDBConnectionPoolTargetSourceImpl(3));
        proxyFactory.setProxyTargetClass(true);

        // 获取代理对象
        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {
            threadPool.execute(() -> {
                ((CustomDBConnection) proxyFactory.getProxy()).printConnectId();
            });
        }
        threadPool.shutdown();
    }
}
