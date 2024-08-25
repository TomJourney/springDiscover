package com.tom.springnote.chapter09.proxyfactory.baseitfproxy;

import com.tom.springnote.common.aop.BusiMessage;
import com.tom.springnote.common.aop.ICallTask;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName ProxyFactoryMain.java
 * @Description TODO
 * @createTime 2024年08月19日 18:55:00
 */
public class BasedItfProxyFactoryMain {
    public static void main(String[] args) {
        RobotCallTaskImpl targetWithItf = new RobotCallTaskImpl(); // 目标对象（实现接口）
        ProxyFactory weaver = new ProxyFactory(targetWithItf); // ProxyFactory作为织入器
        weaver.setInterfaces(ICallTask.class); // 明确告知 ProxyFactory，要对ICallTask接口类型进行代理
        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor(); // 根据名称匹配pointcut的切面
        advisor.setMappedName("call");  // 设置拦截方法名（代理方法名）
        advisor.setAdvice(new CallTaskMethodInterceptor()); // 设置通知
        weaver.addAdvisor(advisor); // 织入器装配切面

        // 织入器织入通过，并获取代理对象
        Object proxy = weaver.getProxy();
        ICallTask proxyObject = (ICallTask) proxy;
//        RobotCallTaskImpl proxyObject = (RobotCallTaskImpl) proxy; // 代理对象转为接口实现类，类型转换失败，报错
        proxyObject.call(BusiMessage.build("任务编号1", "您有待办任务需要处理")); // 通过代理对象调用方法

        // com.tom.springnote.chapter09.springaop.proxyfactory.baseitf.RobotCallTaskImpl@3339ad8e
        System.out.println(proxyObject);
        System.out.println(proxyObject.getClass()); // class jdk.proxy1.$Proxy0  【显然JDK动态代理】
        System.out.println(proxyObject instanceof RobotCallTaskImpl); // false
    }
}
