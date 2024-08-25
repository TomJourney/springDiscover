package com.tom.springnote.chapter05.chapter0501;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.IOException;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName ResourceTypeInjectMain.java
 * @Description resource类型注入入口main
 * @createTime 2024年08月15日 13:58:00
 */
public class ResourceTypeInjectMain {
    public static void main(String[] args) throws IOException {
        // 使用 ClassPathXmlApplicationContext 加载配置文件（默认从classpath加载资源）
        ApplicationContext container =
                new ClassPathXmlApplicationContext("classpath:chapter05/beans0501resourcetypeinject.xml");
        TaskRemindShortMsgSender shortMsgSender = container.getBean("taskRemindShortMsgSender", TaskRemindShortMsgSender.class);
        shortMsgSender.send("张三");

        // 使用 FileSystemXmlApplicationContext 加载配置文件（注意指定classpath前缀，否则从文件系统加载，文件系统找不到，则报错）
//        ApplicationContext noClasspathContainer = new FileSystemXmlApplicationContext("chapter05/beans0501resourcetypeinject.xml");
        ApplicationContext container2 =
                new FileSystemXmlApplicationContext("classpath:chapter05/beans0501resourcetypeinject.xml");
        TaskRemindShortMsgSender shortMsgSender2 = container2.getBean("taskRemindShortMsgSender", TaskRemindShortMsgSender.class);
        shortMsgSender2.send("张三");
    }
}
