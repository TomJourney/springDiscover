package com.tom.springnote.chpater14.jdbccase;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName DaoViaJdbc.java
 * @Description TODO
 * @createTime 2024年08月27日 10:31:00
 */

public class DaoViaJdbc implements IDao {

    public int update(String sql) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionUtils.getConnection();
            statement = connection.createStatement();
            return statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    System.out.println("关闭statement成功");
                } catch (SQLException e) {
                    System.out.println("关闭statement异常");
                    e.printStackTrace(System.err);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("关闭connection成功");
                } catch (SQLException e) {
                    System.out.println("关闭connection异常");
                    e.printStackTrace(System.err);
                }
            }
        }
    }
}
