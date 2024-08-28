package com.tom.springnote.chpater14.jdbctemplate.query;

import com.tom.springnote.chpater14.model.UserDto;

import java.util.Arrays;
import java.util.List;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName QueryByResultSetExtractor.java
 * @Description TODO
 * @createTime 2024年08月27日 21:33:00
 */
public class QueryByResultSetExtractorMain {
    public static void main(String[] args) {
        QueryByResultSetExtractor queryByResultSetExtractor = new QueryByResultSetExtractor();
        List<UserDto> userDtoList = queryByResultSetExtractor.query(
                "select id, name, mobile_phone, addr from user_tbl where id > 500000");
        System.out.println(userDtoList);
    }
}
