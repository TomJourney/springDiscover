package com.tom.springnote.chpater14.operationobject.query;

import com.tom.springnote.chpater14.utils.DataSourceUtils;
import org.springframework.jdbc.object.SqlFunction;

import java.sql.Types;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName SqlFunctionMain.java
 * @Description TODO
 * @createTime 2024年08月28日 19:33:00
 */
public class SqlFunctionMain {
    public static void main(String[] args) {
        String sql = "select count(1) from user_tbl where id >= ?";
        SqlFunction<Integer> sqlFunction = new SqlFunction<>(DataSourceUtils.getDataSource(), sql, new int[]{Types.BIGINT});
        sqlFunction.compile();
        System.out.println(sqlFunction.run(500004));
    }
}
