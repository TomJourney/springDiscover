package com.tom.springnote.chpater14.utils;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName DataSourceUtils.java
 * @Description TODO
 * @createTime 2024年08月27日 21:34:00
 */
public class DataSourceUtils {

    public static DataSource getDataSource() {
        Properties props = new Properties();
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:chapter14/springdiscover_db.properties");
        try (InputStream dbConnConfInputStream = resource.getInputStream()) {
            props.load(dbConnConfInputStream); // 加载数据库连接信息的 .properties 文件
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(props.getProperty("jdbc.drivers"));
        druidDataSource.setUrl(props.getProperty("jdbc.url"));
        druidDataSource.setUsername(props.getProperty("jdbc.username"));
        druidDataSource.setPassword(props.getProperty("jdbc.password"));
        return druidDataSource;
    }

    private DataSourceUtils() {
        // do nothing.
    }
}
