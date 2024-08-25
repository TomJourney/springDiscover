package com.tom.springnote.chapter11.security;

import com.tom.springnote.chapter11.target.UserDAO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName FaultBarrier.java
 * @Description TODO
 * @createTime 2024年08月24日 07:24:00
 */
public class AopAppSecurityCheckMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext container =
                new ClassPathXmlApplicationContext("chapter11/beans11aopappchecksecurity.xml");

        // 获取目标对象的代理对象
        Object userDaoProxy = container.getBean("userDAO");
        try {
            ((UserDAO) userDaoProxy).qryUserNameById("");
        } catch (Exception e) {
            System.out.println("[main] " + e.getMessage());
        }
    }
}
