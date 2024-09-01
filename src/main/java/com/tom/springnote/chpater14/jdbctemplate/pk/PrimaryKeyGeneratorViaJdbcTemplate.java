package com.tom.springnote.chpater14.jdbctemplate.pk;

import com.tom.springnote.utils.DataSourceUtils;
import org.springframework.jdbc.support.incrementer.MySQLMaxValueIncrementer;

import javax.sql.DataSource;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName PrimaryKeyGenerator.java
 * @Description TODO
 * @createTime 2024年08月28日 14:42:00
 */
public class PrimaryKeyGeneratorViaJdbcTemplate {

    private MySQLMaxValueIncrementer pkIncrementGenerator;

    public PrimaryKeyGeneratorViaJdbcTemplate() {
        DataSource dataSource = DataSourceUtils.getDataSource();
        this.pkIncrementGenerator =
                new MySQLMaxValueIncrementer(dataSource, "sequence_tbl", "cur_value");
        pkIncrementGenerator.setCacheSize(5);
    }

    public long getPkViaSequence() {
        return pkIncrementGenerator.nextLongValue();
    }
}
