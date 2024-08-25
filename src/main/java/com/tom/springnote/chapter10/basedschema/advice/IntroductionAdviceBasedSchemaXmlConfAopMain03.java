package com.tom.springnote.chapter10.basedschema.advice;

import com.tom.springnote.chapter10.introductionadviceannotation.IAccessLog;
import com.tom.springnote.chapter10.target.MessageDAO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName BasedSchemaXmlConfAopMain.java
 * @Description TODO
 * @createTime 2024年08月23日 19:33:00
 */
public class IntroductionAdviceBasedSchemaXmlConfAopMain03 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext container =
                new ClassPathXmlApplicationContext("chapter10/basedSchema/beans10AspectjIntroductionAdviceBasedSchema.xml");

        // 获取代理对象
        Object proxy = container.getBean("target");
        ((MessageDAO) proxy).qryMsg("task001");

        // 调用引入型通知接口代理对象的方法
        ((IAccessLog) proxy).sendAccessLog();
    }
}
