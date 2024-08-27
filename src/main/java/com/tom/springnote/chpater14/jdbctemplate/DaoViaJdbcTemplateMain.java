package com.tom.springnote.chpater14.jdbctemplate;

import com.alibaba.druid.support.spring.DruidNativeJdbcExtractor;
import com.tom.springnote.chpater14.jdbccase.DaoViaJdbc;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.Objects;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName JdbcTemplateMain.java
 * @Description TODO
 * @createTime 2024年08月27日 11:05:00
 */
public class DaoViaJdbcTemplateMain {
    public static void main(String[] args) throws Exception {
        DaoViaJdbcTemplate daoViaJdbcTemplate = new DaoViaJdbcTemplate();
        Integer count = daoViaJdbcTemplate.update("INSERT INTO springdiscover.user_tbl(name, mobile_phone, addr, remark) " +
                "VALUES('1', '2', '成都成华大道', 'jdbcTemplate')");
        if (!Objects.isNull(count)) {
            System.out.println("count = " + count);
        }

        DruidNativeJdbcExtractor a;

        NamedParameterJdbcTemplate b ;

        ResultSetExtractor c;

        RowCallbackHandler d;

        RowMapper e;
    }
}
