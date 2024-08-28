package com.tom.springnote.chpater14.jdbctemplate.update;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName SingleUpdateViaJdbcTemplate.java
 * @Description TODO
 * @createTime 2024年08月28日 10:21:00
 */
public class SingleUpdateViaJdbcTemplateMain {
    public static void main(String[] args) {
        SingleUpdateViaJdbcTemplate singleUpdateViaJdbcTemplate = new SingleUpdateViaJdbcTemplate();
        singleUpdateViaJdbcTemplate.updateByPreparedStatementSetter("");
        singleUpdateViaJdbcTemplate.updateByPreparedStatementCreator("");
    }
}
