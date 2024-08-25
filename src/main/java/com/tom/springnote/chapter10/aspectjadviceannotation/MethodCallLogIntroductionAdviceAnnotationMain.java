package com.tom.springnote.chapter10.aspectjadviceannotation;

import com.tom.springnote.chapter10.introductionadviceannotation.IAccessLog;
import com.tom.springnote.chapter10.target.MessageDAO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName CallTaskBeforeAnnotation.java
 * @Description TODO
 * @createTime 2024年08月23日 11:39:00
 */
public class MethodCallLogIntroductionAdviceAnnotationMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext container =
                new ClassPathXmlApplicationContext("chapter10/advice/beans10AspectjIntroductionAdviceAnnotationXsd.xml");

        // 获取代理对象
        Object proxy = container.getBean("target");
        // 根据任务编号查询待发送消息
        ((MessageDAO) proxy).qryMsg("task001");

        // 转为Introduction通知接口，调用横切逻辑方法
        ((IAccessLog) proxy).sendAccessLog();
    }
}
