package com.tom.springnote.chapter09.perclassadvice.beforeadvice;

import com.tom.springnote.common.aop.BusiMessage;
import com.tom.springnote.common.aop.ManNoItfCallTask;
import org.aopalliance.aop.Advice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName beforeadvice.java
 * @Description TODO
 * @createTime 2024年08月21日 14:41:00
 */
public class DefaultPointcutAdvisorMain {
    public static void main(String[] args) {
        // 构建匹配切点位置的表达式
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedName("call");
        // 构建横切逻辑
        Advice beforeAdvice = new MethodRequestLogBeforeAdviceImpl();
        // 组装切面
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut, beforeAdvice);
        // 新建织入器，并装配目标对象和切面
        ManNoItfCallTask target = new ManNoItfCallTask();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvisor(advisor);
        // 织入器织入并获取代理对象
        ManNoItfCallTask proxy = (ManNoItfCallTask) proxyFactory.getProxy();
        proxy.call(BusiMessage.build("task001", "您有待办任务需要处理"));
    }
}
