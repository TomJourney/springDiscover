package com.tom.springnote.chapter09.perclassadvice.ordered;

import com.tom.springnote.chapter09.perclassadvice.beforeadvice.MethodRequestLogBeforeAdviceImpl;
import com.tom.springnote.common.aop.BusiMessage;
import com.tom.springnote.common.aop.ManNoItfCallTask;
import org.aopalliance.aop.Advice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

import java.sql.SQLOutput;
import java.util.List;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName OrderedDefaultPointcutAdvisorMain.java
 * @Description TODO
 * @createTime 2024年08月21日 21:08:00
 */
public class OrderedDefaultPointcutAdvisorMain {

    public static void main(String[] args) {
        // 新建切点位置
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedName("call");
        // 新建多个切面
        DefaultPointcutAdvisor requestLogAdvisor = new DefaultPointcutAdvisor(pointcut, new MethodRequestLogBeforeAdviceImpl());
        // 设置切面执行顺序（值越小，优先级越高）
        requestLogAdvisor.setOrder(10);
        DefaultPointcutAdvisor counterAdvisor = new DefaultPointcutAdvisor(pointcut, new MethodCallCounterBeforeAdviceImpl());
        counterAdvisor.setOrder(9);
        // 把多个切面添加到织入器
        ManNoItfCallTask target = new ManNoItfCallTask();
        ProxyFactory weaver = new ProxyFactory(target);
        weaver.addAdvisors(List.of(counterAdvisor, requestLogAdvisor));
        // 通过织入器织入并获取代理对象
        ManNoItfCallTask proxy = (ManNoItfCallTask) weaver.getProxy();
        proxy.call(BusiMessage.build("task001", "您有待办任务需要处理"));

        System.out.println("====== 我是分割线 ======");
        proxy.call(BusiMessage.build("task002", "您有待办任务需要处理"));
    }
}
