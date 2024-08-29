package com.tom.springnote.chpater14.operationobject.update;

import com.tom.springnote.chpater14.utils.DataSourceUtils;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import java.sql.Types;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName SqlUpdateMain.java
 * @Description TODO
 * @createTime 2024年08月28日 19:50:00
 */
public class SqlUpdateMain {
    public static void main(String[] args) {
        String sql = "update user_tbl set mobile_phone = ? where id >= ?";
        SqlUpdate sqlUpdate = new SqlUpdate(DataSourceUtils.getDataSource(), sql);
        sqlUpdate.declareParameter(new SqlParameter(Types.VARCHAR));
        sqlUpdate.declareParameter(new SqlParameter(Types.BIGINT));
        sqlUpdate.compile(); // 调用compile()方法，检查与设置操作对象sqlUpdate所必须的各种参数

        // 执行sql
        sqlUpdate.update(new Object[]{"123456", 500004});
    }
}
