package com.tom.springnote.chapter09.proxyfactory.baseclassproxy;

import com.tom.springnote.chapter09.proxyfactory.baseitfproxy.CallTaskMethodInterceptor;
import com.tom.springnote.chapter09.proxyfactory.baseitfproxy.RobotCallTaskImpl;
import com.tom.springnote.common.aop.BusiMessage;
import com.tom.springnote.common.aop.ICallTask;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName HasItfCallBasedClassProxyFactoryMain.java
 * @Description TODO
 * @createTime 2024年08月20日 06:27:00
 */
public class ImplItfBasedClassProxyFactoryMain {
    public static void main(String[] args) {
        ProxyFactory weaver = new ProxyFactory(new RobotCallTaskImpl());
        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
        advisor.setMappedName("call");
        advisor.setAdvice(new CallTaskMethodInterceptor());
        weaver.addAdvisor(advisor);
//        weaver.setProxyTargetClass(true); // 方式1：设置 proxyTargetClass=true，即可使用CGLIB动态代理，无论目标类实现接口与否
        weaver.setOptimize(true); // 方式2：设置 optimize=true，即可使用CGLIB动态代理，无论目标类实现接口与否
        // 获取代理对象
        ICallTask proxyObject = (ICallTask) weaver.getProxy();
        proxyObject.call(BusiMessage.build("任务编号01", "您有待办任务需要处理"));
        // com.tom.springnote.chapter09.springaop.proxyfactory.baseitfproxy.RobotCallTaskImpl@6eebc39e
        System.out.println(proxyObject);
        // class com.tom.springnote.chapter09.springaop.proxyfactory.baseitfproxy.RobotCallTaskImpl$$SpringCGLIB$$0
        System.out.println(proxyObject.getClass());
    }
}
