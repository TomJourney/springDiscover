package com.tom.srccode.deep.analysis.chapter0501.beans;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

import java.util.Date;

/**
 * @author tom
 * @version 1.0.0
 * @Description TODO
 * @createTime 2026年06月27日 06:51:00
 */
@Getter
@Slf4j
public class TomAccountService implements ApplicationContextAware, EnvironmentAware, InitializingBean {

    private String testStr = "tom test";
    private ApplicationContext applicationContext;
    private Environment environment;
    private Date birthday;
    private String name;

    public TomAccountService() {
        log.info("TomAccountService示例被创建");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        log.info("applicationContext-装配完成");

        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
        log.info("environment-装配完成");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.testStr = testStr + "-afterPropertiesSet触发";
        log.info("InitializingBean-afterPropertiesSet()触发");
    }

    public void myInitMethod() {
        log.info("myInitMethod()方法触发");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "TomAccountService{" +
                "testStr='" + testStr + '\'' +
                ", birthday=" + birthday +
                ", name=" + name +
                '}';
    }
}
