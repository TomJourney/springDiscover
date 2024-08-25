package com.tom.springnote.chapter06.autowirebasedxml;

import com.tom.springnote.chapter05.chapter0504.RoomBookAppService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName MultiModuleLoadMain.java
 * @Description TODO
 * @createTime 2024年08月16日 06:28:00
 */
public class AutoWireXmlConfMain {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("classpath:chapter06/beans0601autowirebasedxml.xml");
        container.getBean(RoomBookAppService.class).book("基于xml配置文件的自动绑定房间01", "张三");
    }
}
