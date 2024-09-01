package com.tom.springnote.chpater14.jdbctemplate.pk;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName PrimaryKeyGenerator.java
 * @Description TODO
 * @createTime 2024年08月28日 14:42:00
 */
public class PrimaryKeyGeneratorViaJdbcTemplateMain {

    public static void main(String[] args) {
        PrimaryKeyGeneratorViaJdbcTemplate primaryKeyGeneratorViaJdbcTemplate = new PrimaryKeyGeneratorViaJdbcTemplate();
        for (int i = 0; i < 101; i++) {
            System.out.println(primaryKeyGeneratorViaJdbcTemplate.getPkViaSequence());
        }
    }
}
