package com.tom.springnote.chapter14.jdbctemplate.query;

import com.tom.springnote.chapter14.model.UserDto;
import com.tom.springnote.utils.DataSourceUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName QueryByRowCallbackHandler.java
 * @Description TODO
 * @createTime 2024年08月27日 21:46:00
 */
public class QueryByRowCallbackHandler {
    public List<UserDto> query(String sql) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceUtils.getDataSource());
        List<UserDto> userDtoList = new ArrayList<>();
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                UserDto userDto = new UserDto();
                userDto.setId(Integer.parseInt(rs.getString("id")));
                userDto.setName(rs.getString("name"));
                userDto.setMobilePhone(rs.getString("mobile_phone"));
                userDto.setAddr(rs.getString("addr"));
                userDtoList.add(userDto);
            }
        });
        return userDtoList;
    }
}
