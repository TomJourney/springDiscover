package com.tom.springnote.chapter14.jdbccase;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName DaoViaJdbc.java
 * @Description TODO
 * @createTime 2024年08月27日 10:31:00
 */

public class DaoViaJdbcMain {
    public static void main(String[] args) {
        DaoViaJdbc daoViaJdbc = new DaoViaJdbc();
        daoViaJdbc.update("INSERT INTO springdiscover.user_tbl(name, mobile_phone, addr) VALUES('1', '2', '3')");
    }
}
