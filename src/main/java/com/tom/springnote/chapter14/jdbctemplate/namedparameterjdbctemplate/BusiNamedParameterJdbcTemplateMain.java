package com.tom.springnote.chapter14.jdbctemplate.namedparameterjdbctemplate;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName BusiNamedParameterJdbcTemplate.java
 * @Description TODO
 * @createTime 2024年08月28日 16:14:00
 */
public class BusiNamedParameterJdbcTemplateMain {
    public static void main(String[] args) {
        BusiNamedParameterJdbcTemplate busiNamedParameterJdbcTemplate = new BusiNamedParameterJdbcTemplate();
        System.out.println(busiNamedParameterJdbcTemplate.queryUserById(500005));

        System.out.println(busiNamedParameterJdbcTemplate.queryUserById2(500005));
    }
}
