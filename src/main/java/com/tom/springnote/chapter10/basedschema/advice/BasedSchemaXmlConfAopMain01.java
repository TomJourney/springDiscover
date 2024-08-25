package com.tom.springnote.chapter10.basedschema.advice;

import com.tom.springnote.chapter10.target.MessageDAO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName BasedSchemaXmlConfAopMain.java
 * @Description TODO
 * @createTime 2024年08月23日 19:33:00
 */
public class BasedSchemaXmlConfAopMain01 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext container =
                new ClassPathXmlApplicationContext("chapter10/basedSchema/beans10AspectjBasedSchema.xml");

        // 获取代理对象
        Object proxy = container.getBean("target");
        ((MessageDAO) proxy).qryMsg("task001");
    }
}
