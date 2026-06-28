package com.tom.srccode.deep.analysis.chapter8.springjdbc;

import com.tom.srccode.deep.analysis.chapter0501.beans.TomAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author tom
 * @version 1.0.0
 * @Description TODO
 * @createTime 2026年06月28日 20:42:00
 */
@Slf4j
public class SpringJdbcMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("/a_src_deep_analysis/chapter08/beans0801.xml");

        UserServiceImpl userService = applicationContext.getBean("userService", UserServiceImpl.class);
        UserPO userPO = new UserPO("zhangsan", 10, "男");
        userService.save(userPO);

        // 查询数据
        List<UserPO> users = userService.getUsers();
        users.forEach(System.out::println);
    }
}
