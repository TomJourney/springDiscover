package com.tom.springnote.chapter05.chapter0504;

import com.tom.springnote.chapter06.autowirebasedxml.RoomBookAppService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName MultiModuleLoadMain.java
 * @Description TODO
 * @createTime 2024年08月16日 06:28:00
 */
public class MultiConfXmlLoadMain {
    public static void main(String[] args) {
        // 方式1： 详细指定每个bean xml配置文件
        String[] locations = {"chapter0504multiconfxml/conf/beans-busi.xml"
                , "chapter0504multiconfxml/conf/beans-support.xml"
                , "chapter0504multiconfxml/conf/beans-dao.xml"};
        ApplicationContext container = new ClassPathXmlApplicationContext(locations);
        container.getBean("roomBookAppService", com.tom.springnote.chapter06.autowirebasedxml.RoomBookAppService.class).book("1", "zhangsan");

        // 方式2： 使用通配符， PathMatchingResourcePatternResolver支持基于ant风格的路径匹配模式（类型 **/*.suffix之类的路径形式）
        String[] locationsByWildcard = {"chapter0504multiconfxml/conf/*.xml"};
        ApplicationContext containerByWildcard = new ClassPathXmlApplicationContext(locationsByWildcard);
        containerByWildcard.getBean("roomBookAppService", RoomBookAppService.class).book("通配符2", "通配符lisi");
    }
}
