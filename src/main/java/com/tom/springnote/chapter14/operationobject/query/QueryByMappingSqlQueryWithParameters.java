package com.tom.springnote.chapter14.operationobject.query;

import com.tom.springnote.chapter14.model.UserDto;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQueryWithParameters;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Map;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName QueryByMappingSqlQueryWithParameters.java
 * @Description TODO
 * @createTime 2024年08月28日 17:52:00
 */
public class QueryByMappingSqlQueryWithParameters extends MappingSqlQueryWithParameters<UserDto> {

    static String sql = "select id, name, mobile_phone from user_tbl where id >= ?";

    public QueryByMappingSqlQueryWithParameters(DataSource dataSource) {
        super(dataSource, sql);
        super.declareParameter(new SqlParameter(Types.BIGINT));
        super.compile();
    }

    @Override
    protected UserDto mapRow(ResultSet rs, int rowNum, Object[] parameters, Map context) throws SQLException {
        UserDto userDto = new UserDto();
        userDto.setId(rs.getLong(1));
        userDto.setName(rs.getString(2));
        userDto.setMobilePhone(rs.getString(3));
        return userDto;
    }
}
