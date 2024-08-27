package com.tom.springnote.chpater14.jdbctemplate;

import com.alibaba.druid.pool.DruidDataSource;
import com.tom.springnote.chpater14.utils.DataSourceUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.StatementCallback;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName BusiJdbcTemplate.java
 * @Description TODO
 * @createTime 2024年08月27日 11:05:00
 */
public class DaoViaJdbcTemplate {
    public Integer update(String sql) {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceUtils.getDataSource());
        StatementCallback<Integer> statementCallback = new StatementCallback<>() {
            @Override
            public Integer doInStatement(Statement stmt) throws SQLException {
                return stmt.executeUpdate(sql);
            }
        };
        return jdbcTemplate.execute(statementCallback);
    }


}
