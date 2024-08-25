package com.tom.springnote.chapter11.cache;

import com.tom.springnote.chapter11.target.UserDAO;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName CacheAspect.java
 * @Description TODO
 * @createTime 2024年08月24日 09:44:00
 */
public class AopCacheAspectMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext container =
                new ClassPathXmlApplicationContext("chapter11/beans11aopappcache.xml");

        // 获取代理对象
        Object proxy = container.getBean("userDAO");
        ((UserDAO) proxy).qryUserNameById("01");
        ((UserDAO) proxy).qryUserNameById("01");
        ((UserDAO) proxy).qryUserNameById("02");
        ((UserDAO) proxy).qryUserNameById("01");
    }
}
