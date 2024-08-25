package com.tom.springnote.chapter11.faultbarrier;

import com.tom.springnote.chapter11.target.BusiFileReader;
import com.tom.springnote.chapter11.target.UserDAO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName FaultBarrier.java
 * @Description TODO
 * @createTime 2024年08月24日 07:24:00
 */
public class AopAppFaultBarrierMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext container =
                new ClassPathXmlApplicationContext("chapter11/beans11aopappfaultbarrier.xml");

        // 获取目标对象的代理对象
        Object proxy = container.getBean("target");
        try {
            ((BusiFileReader) proxy).readFileName("abcd");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // 获取目标对象的代理对象
        System.out.println("==== 我是分割线 ====");
        Object userDaoProxy = container.getBean("userDAO");
        try {
            ((UserDAO) userDaoProxy).qryUserNameById("");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
