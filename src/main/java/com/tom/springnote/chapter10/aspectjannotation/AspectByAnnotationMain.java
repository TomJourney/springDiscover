package com.tom.springnote.chapter10.aspectjannotation;

import com.tom.springnote.common.aop.BusiMessage;
import com.tom.springnote.common.aop.ManNoItfCallTask;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName AspectjAnnotationMain.java
 * @Description TODO
 * @createTime 2024年08月23日 06:42:00
 */
public class AspectByAnnotationMain {
    public static void main(String[] args) {
        AspectJProxyFactory weaver = new AspectJProxyFactory();
        weaver.setProxyTargetClass(true);
        weaver.setTarget(new ManNoItfCallTask());
        weaver.addAspect(TimeCostAspectByAnnotation.class);

        // 获取代理对象
        Object proxy = weaver.getProxy();
        ((ManNoItfCallTask) proxy).call(BusiMessage.build("任务编号001", "您有待办任务需要处理"));
        System.out.println(proxy.getClass());
    }
}
