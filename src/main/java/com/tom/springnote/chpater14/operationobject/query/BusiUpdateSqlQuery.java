package com.tom.springnote.chpater14.operationobject.query;

import com.tom.springnote.chpater14.model.UserDto;
import org.springframework.jdbc.object.UpdatableSqlQuery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName BusiUpdateSqlQuery.java
 * @Description TODO
 * @createTime 2024年08月28日 19:45:00
 */
public class BusiUpdateSqlQuery extends UpdatableSqlQuery<UserDto> {
    @Override
    protected UserDto updateRow(ResultSet rs, int rowNum, Map<?, ?> context) throws SQLException {
        return null;
    }
}
