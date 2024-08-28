package com.tom.springnote.chpater14.jdbctemplate.query;

import com.tom.springnote.chpater14.model.UserDto;
import com.tom.springnote.chpater14.utils.DataSourceUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName QueryByResultSetExtractor.java
 * @Description TODO
 * @createTime 2024年08月27日 21:33:00
 */
public class QueryByResultSetExtractor {
    public List<UserDto> query(String sql) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceUtils.getDataSource());
        return jdbcTemplate.query(sql, new ResultSetExtractor<>() {
            List<UserDto> userDtoList = new ArrayList<>();
            @Override
            public List<UserDto> extractData(ResultSet rs) throws SQLException, DataAccessException {
                while(rs.next()) {
                    UserDto userDto = new UserDto();
                    userDto.setId(Integer.parseInt(rs.getString("id")));
                    userDto.setName(rs.getString("name"));
                    userDto.setMobilePhone(rs.getString("mobile_phone"));
                    userDto.setAddr(rs.getString("addr"));
                    userDtoList.add(userDto);
                }
                return userDtoList;
            }
        });
    }
}
