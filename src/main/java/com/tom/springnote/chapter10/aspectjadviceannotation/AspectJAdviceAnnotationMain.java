package com.tom.springnote.chapter10.aspectjadviceannotation;

import com.tom.springnote.chapter10.target.MessageDAO;
import com.tom.springnote.common.aop.BusiMessage;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName AspectJBeforeAnnotationMain.java
 * @Description TODO
 * @createTime 2024年08月23日 11:39:00
 */
public class AspectJAdviceAnnotationMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext container =
                new ClassPathXmlApplicationContext("chapter10/advice/beans10AspectjAdviceAnnotationXsd.xml");

        // 获取代理对象
        Object proxy = container.getBean("target");
        // 根据任务编号查询待发送消息
        BusiMessage busiMessage = ((MessageDAO) proxy).qryMsg("task001");
        System.out.println("main: " + busiMessage);
    }
}
