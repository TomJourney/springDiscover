package com.tom.springnote.chpater14.jdbccase;

import com.tom.springnote.chpater14.model.UserDto;

import java.util.Arrays;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName BatchUpdateViaJdbc.java
 * @Description TODO
 * @createTime 2024年08月28日 20:34:00
 */
public class BatchUpdateViaJdbcMain {
    public static void main(String[] args) {
        BatchUpdateViaJdbc batchUpdateViaJdbc = new BatchUpdateViaJdbc();
        batchUpdateViaJdbc.batchInsert(Arrays.asList(
           new UserDto("批量王五01", "12345678901", "成都01", "批量备注01")
           , new UserDto("批量王五02", "12345678902", "成都02", "批量备注02")
        ));
    }
}
