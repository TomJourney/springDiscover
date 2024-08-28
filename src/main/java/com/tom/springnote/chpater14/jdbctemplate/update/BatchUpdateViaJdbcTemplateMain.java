package com.tom.springnote.chpater14.jdbctemplate.update;

import com.tom.springnote.chpater14.model.UserDto;
import org.springframework.jdbc.support.SQLStateSQLExceptionTranslator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName SingleUpdateViaJdbcTemplate.java
 * @Description TODO
 * @createTime 2024年08月28日 10:21:00
 */
public class BatchUpdateViaJdbcTemplateMain {
    public static void main(String[] args) {
        List<UserDto> userDtoArrayList = new ArrayList<UserDto>();
        userDtoArrayList.add(new UserDto(500001, "batchUpdate01A", "", ""));
        userDtoArrayList.add(new UserDto(500002, "batchUpdate02A", "", ""));
        BatchUpdateViaJdbcTemplate batchUpdateViaJdbcTemplate = new BatchUpdateViaJdbcTemplate();
        batchUpdateViaJdbcTemplate.batchUpdateByPreparedStatementCreator(userDtoArrayList);

        // 批量插入
        List<UserDto> userDtoArrayList2 = new ArrayList<UserDto>();
        userDtoArrayList2.add(new UserDto( "张三A100", "18881880001", "成都01", "备注01"));
        userDtoArrayList2.add(new UserDto( "张三A102", "18881880002", "成都02", "备注02"));
//        batchUpdateViaJdbcTemplate.batchInsertByPreparedStatementCreator(userDtoArrayList2);

        // 批量删除
        List<UserDto> userDtoArrayList3 = new ArrayList<UserDto>();
        userDtoArrayList3.add(new UserDto( 500001, "18881880001", "成都01", "备注01"));
        userDtoArrayList3.add(new UserDto( 500002, "18881880002", "成都02", "备注02"));
        batchUpdateViaJdbcTemplate.batchDeleteByPreparedStatementCreator(userDtoArrayList3);
    }
}
