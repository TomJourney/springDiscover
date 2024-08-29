package com.tom.springnote.chpater14.jdbctemplate.namedparameterjdbctemplate;

import com.tom.springnote.chpater14.utils.DataSourceUtils;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName BusiNamedParameterJdbcTemplate.java
 * @Description TODO
 * @createTime 2024年08月28日 16:14:00
 */
public class BusiNamedParameterJdbcTemplate {

    public Map<String, Object> queryUserById(int id) {
        String sql = "select id, name from user_tbl where id = :id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(DataSourceUtils.getDataSource());
        SqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
        return namedParameterJdbcTemplate.queryForMap(sql, parameterSource);
    }

    public Map<String, Object> queryUserById2(int id) {
        String sql = "select id, name from user_tbl where id = :id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(DataSourceUtils.getDataSource());
        Map<String, Object> params = new HashMap<>();
        params.put("id" ,id);
        return namedParameterJdbcTemplate.queryForMap(sql, params);
    }
}
