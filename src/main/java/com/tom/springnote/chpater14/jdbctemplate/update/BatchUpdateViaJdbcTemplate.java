package com.tom.springnote.chpater14.jdbctemplate.update;

import com.tom.springnote.chpater14.model.UserDto;
import com.tom.springnote.chpater14.utils.DataSourceUtils;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName SingleUpdateViaJdbcTemplate.java
 * @Description TODO
 * @createTime 2024年08月28日 10:21:00
 */
public class BatchUpdateViaJdbcTemplate  {
    public void batchUpdateByPreparedStatementCreator(List<UserDto> userDtoList) {
        String sql2 = "update user_tbl set name = ? where id = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceUtils.getDataSource());
        jdbcTemplate.batchUpdate(sql2, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                UserDto userDto = userDtoList.get(i);
                ps.setString(1, userDto.getName());
                ps.setLong(2, userDto.getId());
            }

            @Override
            public int getBatchSize() {
                return userDtoList.size();
            }
        });
    }

    public void batchInsertByPreparedStatementCreator(List<UserDto> userDtoList) {
        String sql2 = "insert into user_tbl(name, mobile_phone, addr, remark) values (?, ?, ?, ?)";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceUtils.getDataSource());
        jdbcTemplate.batchUpdate(sql2, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                UserDto userDto = userDtoList.get(i);
                ps.setString(1, userDto.getName());
                ps.setString(2, userDto.getMobilePhone());
                ps.setString(3, userDto.getAddr());
                ps.setString(4, userDto.getRemark());
            }

            @Override
            public int getBatchSize() {
                return userDtoList.size();
            }
        });
    }

    public void batchDeleteByPreparedStatementCreator(List<UserDto> userDtoList) {
        String sql2 = "delete from user_tbl where id = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceUtils.getDataSource());
        jdbcTemplate.batchUpdate(sql2, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                UserDto userDto = userDtoList.get(i);
                ps.setLong(1, userDto.getId());
            }

            @Override
            public int getBatchSize() {
                return userDtoList.size();
            }
        });
    }
}
