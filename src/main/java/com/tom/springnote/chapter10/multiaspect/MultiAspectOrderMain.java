package com.tom.springnote.chapter10.multiaspect;

import com.tom.springnote.chapter10.target.MessageDAO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName main.java
 * @Description TODO
 * @createTime 2024年08月23日 16:00:00
 */
public class MultiAspectOrderMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext container =
                new ClassPathXmlApplicationContext("chapter10/advice/beans10AspectjMultiAspectAnnotationXsd.xml");

        Object proxy = container.getBean("target");
        ((MessageDAO) proxy).qryMsg("task001");
    }
}
