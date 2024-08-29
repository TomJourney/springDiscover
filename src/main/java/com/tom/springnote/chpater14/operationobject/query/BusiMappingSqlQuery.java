package com.tom.springnote.chpater14.operationobject.query;

import com.tom.springnote.chpater14.model.UserDto;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName BusiMappingSqlQuery.java
 * @Description TODO
 * @createTime 2024年08月28日 19:18:00
 */
public class BusiMappingSqlQuery extends MappingSqlQuery<UserDto> {

    private static String sql = "select id, name, mobile_phone from user_tbl where id >= ?";

    public BusiMappingSqlQuery(DataSource ds) {
        super(ds, sql);
        super.declareParameter(new SqlParameter(Types.BIGINT));
        super.compile();
    }

    @Override
    protected UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserDto userDto = new UserDto();
        userDto.setId(rs.getLong(1));
        userDto.setName(rs.getString(2));
        userDto.setMobilePhone(rs.getString(3));
        return userDto;
    }
}
