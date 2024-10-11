package com.tom.springnote.chapter14.jdbccase;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName ConnectionUtils.java
 * @Description TODO
 * @createTime 2024年08月28日 20:34:00
 */
public class ConnectionUtils {

    public static Connection getConnection() throws SQLException {
        Properties props = new Properties();
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:chapter14/springdiscover_db.properties");
        try (InputStream dbConnConfInputStream = resource.getInputStream()) {
            props.load(dbConnConfInputStream); // 加载数据库连接信息的 .properties 文件
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
        String drivers = props.getProperty("jdbc.drivers"); //数据库驱动器
        if (drivers != null) System.setProperty("jdbc.drivers", drivers);
        String url = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");

        return DriverManager.getConnection(url, username, password); //利用驱动管理器打开一个数据库连接
    }

    private ConnectionUtils() {
        // do nothing.
    }
}
