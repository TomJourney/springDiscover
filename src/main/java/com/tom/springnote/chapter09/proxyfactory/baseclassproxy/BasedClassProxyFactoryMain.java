package com.tom.springnote.chapter09.proxyfactory.baseclassproxy;

import com.tom.springnote.chapter09.proxyfactory.baseitfproxy.CallTaskMethodInterceptor;
import com.tom.springnote.common.aop.BusiMessage;
import com.tom.springnote.common.aop.ManNoItfCallTask;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName BasedClassProxyFactoryMain.java
 * @Description TODO
 * @createTime 2024年08月20日 06:10:00
 */
public class BasedClassProxyFactoryMain {
    public static void main(String[] args) {
        // 新建织入器，装配目标对象, 切面
        ManNoItfCallTask target = new ManNoItfCallTask();
        ProxyFactory weaver = new ProxyFactory(target);
        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
        advisor.setMappedName("call");
        advisor.setAdvice(new CallTaskMethodInterceptor());
        weaver.addAdvisor(advisor);

        // 织入器织入通知，并获取代理对象
        ManNoItfCallTask proxyObject = (ManNoItfCallTask) weaver.getProxy();
        proxyObject.call(BusiMessage.build("任务编号1", "您有待办任务需要处理"));

        // com.tom.springnote.common.aop.ManNoItfCallTask@13deb50e
        System.out.println(proxyObject);
        // class com.tom.springnote.common.aop.ManNoItfCallTask$$SpringCGLIB$$0
        System.out.println(proxyObject.getClass());
        System.out.println(proxyObject instanceof ManNoItfCallTask); // true
    }
}
