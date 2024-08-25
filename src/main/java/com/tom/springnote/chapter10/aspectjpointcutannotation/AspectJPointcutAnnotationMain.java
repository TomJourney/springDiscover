package com.tom.springnote.chapter10.aspectjpointcutannotation;

import com.tom.springnote.common.aop.BusiMessage;
import com.tom.springnote.common.aop.ManNoItfCallTask;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName AspectByAspectJAnnotation.java
 * @Description TODO
 * @createTime 2024年08月23日 09:41:00
 */
@Aspect
public class AspectJPointcutAnnotationMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext container =
                new ClassPathXmlApplicationContext("chapter10/beans10aspectjpointcutannotationxsd.xml");

        // 获取代理对象
        Object proxy = container.getBean("target");
        ((ManNoItfCallTask) proxy).call(BusiMessage.build("任务编号001", "您有待办任务需要处理"));
    }
}
