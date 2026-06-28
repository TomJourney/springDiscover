package com.tom.srccode.deep.analysis.chapter8.springjdbc;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author tom
 * @version 1.0.0
 * @Description TODO
 * @createTime 2026年06月28日 20:31:00
 */
public class UserRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserPO person = new UserPO(rs.getString("id"), rs.getString("name"), rs.getInt("age"), rs.getString("sex"));
        return person;
    }
}
