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
public class WeaveBeforeAdviceMain {
    public static void main(String[] args) {
        // 构建切点位置
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedName("call");
        // 构建横切逻辑
        Advice beforeAdvice = new MethodRequestLogBeforeAdviceImpl();
        // 组装切面
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut, beforeAdvice);
        // 织入器ProxyFactory织入切面到目标对象
        ManNoItfCallTask target = new ManNoItfCallTask();
        ProxyFactory weaver = new ProxyFactory(target);
        // 通过织入器获取代理对象
    }
}
