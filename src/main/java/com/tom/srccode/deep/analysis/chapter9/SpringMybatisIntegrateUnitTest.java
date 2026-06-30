package com.tom.srccode.deep.analysis.chapter9;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tom
 * @version 1.0.0
 * @Description spring与mybatis整合的单元测试
 * @createTime 2026年07月01日 06:50:00
 */
@Slf4j
public class SpringMybatisIntegrateUnitTest {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("a_src_deep_analysis/chapter9/spring-mybatis-beans.xml");
        UserMapper userMapper = context.getBean(UserMapper.class);
        log.info("user = {}", userMapper.getUser("3"));
    }

}
