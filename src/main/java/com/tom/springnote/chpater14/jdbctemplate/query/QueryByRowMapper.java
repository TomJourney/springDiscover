package com.tom.springnote.chpater14.jdbctemplate.query;

import com.tom.springnote.chpater14.model.UserDto;
import com.tom.springnote.chpater14.utils.DataSourceUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName QueryByRowCallbackHandler.java
 * @Description TODO
 * @createTime 2024年08月27日 21:46:00
 */
public class QueryByRowMapper {
    public List<UserDto> query(String sql) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceUtils.getDataSource());
        return jdbcTemplate.query(sql, new RowMapper<>() {
            @Override
            public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserDto userDto = new UserDto();
                userDto.setId(Integer.parseInt(rs.getString("id")));
                userDto.setName(rs.getString("name"));
                userDto.setMobilePhone(rs.getString("mobile_phone"));
                userDto.setAddr(rs.getString("addr"));
                return userDto;
            }
        });
    }
}
