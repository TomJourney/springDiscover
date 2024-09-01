package com.tom.springnote.chpater14.jdbctemplate.update;

import com.tom.springnote.utils.DataSourceUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName SingleUpdateViaJdbcTemplate.java
 * @Description TODO
 * @createTime 2024年08月28日 10:21:00
 */
public class SingleUpdateViaJdbcTemplate {
    public void updateByPreparedStatementSetter(String sql) {
        sql = "update user_tbl set name = ? where id = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceUtils.getDataSource());
        jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, "张三01A");
                ps.setInt(2, 500001);
            }
        });
    }

    public void updateByPreparedStatementCreator(String sql) {
        String sql2 = "update user_tbl set name = ? where id = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceUtils.getDataSource());
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(sql2);
                ps.setString(1, "张三02B");
                ps.setInt(2, 500002);
                return ps;
            }
        });
    }
}
