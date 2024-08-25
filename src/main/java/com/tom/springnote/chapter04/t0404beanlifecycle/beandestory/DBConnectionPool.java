package com.tom.springnote.chapter04.t0404beanlifecycle.beandestory;

import com.tom.springnote.chapter04.t0404beanlifecycle.customBeanPostProcessor.PasswordDecodable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.*;
import org.springframework.core.io.ResourceLoader;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName DBConnectionPool.java
 * @Description 模拟数据库连接池管理
 * @createTime 2024年08月04日 22:12:00
 */
public class DBConnectionPool implements InitializingBean, DisposableBean, PasswordDecodable
        , ResourceLoaderAware, ApplicationEventPublisherAware, MessageSourceAware, ApplicationContextAware {

    private JdbcService jdbcService;

    private String password;

    public DBConnectionPool() {
        System.out.println("DBConnectionPool：构造器");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("DBConnectionPool： InitializingBean#afterPropertiesSet()-建立与mysql连接");
        jdbcService.createConnection();
    }

    public void init() {
        System.out.println("DBConnectionPool： init-method#init()-建立与mysql连接");
        jdbcService.createConnection();
    }

    public void closeConnection() {
        System.out.println("DBConnectionPool： destory-method#closeConnection()-关闭数据库连接");
        jdbcService.createConnection();
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DBConnectionPool： DisposableBean#destroy()-关闭数据库连接");
        jdbcService.createConnection();
    }

    public void setJdbcService(JdbcService jdbcService) {
        System.out.println("DBConnectionPool： 调用setJdbcService()");
        this.jdbcService = jdbcService;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("DBConnectionPool： ApplicationContextAware#setApplicationContext()");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        System.out.println("DBConnectionPool： ApplicationEventPublisherAware#setApplicationEventPublisher()");
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        System.out.println("DBConnectionPool： MessageSourceAware#setMessageSource()");
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println("DBConnectionPool： ResourceLoaderAware#setResourceLoader()");
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setDecodedPassword(String password) {
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
