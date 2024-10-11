package com.tom.springnote.chapter14.jdbctemplate.query;

import com.tom.springnote.chapter14.model.UserDto;

import java.util.List;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName QueryByRowCallbackHandler.java
 * @Description TODO
 * @createTime 2024年08月27日 21:46:00
 */
public class QueryByRowMapperMain {
    public static void main(String[] args) {
        QueryByRowMapper queryByRowMapper = new QueryByRowMapper();
        List<UserDto> userDtoList = queryByRowMapper.query(
                "select id, name, mobile_phone, addr from user_tbl where id > 500000");
        System.out.println(userDtoList);
    }
}
