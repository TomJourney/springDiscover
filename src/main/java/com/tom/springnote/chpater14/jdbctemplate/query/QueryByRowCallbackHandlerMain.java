package com.tom.springnote.chpater14.jdbctemplate.query;

import com.tom.springnote.chpater14.model.UserDto;

import java.util.List;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName QueryByRowCallbackHandler.java
 * @Description TODO
 * @createTime 2024年08月27日 21:46:00
 */
public class QueryByRowCallbackHandlerMain {
    public static void main(String[] args) {
        QueryByRowCallbackHandler queryByRowCallbackHandler = new QueryByRowCallbackHandler();
        List<UserDto> userDtoList = queryByRowCallbackHandler.query(
                "select id, name, mobile_phone, addr from user_tbl where id > 500000");
        System.out.println(userDtoList);
    }
}
