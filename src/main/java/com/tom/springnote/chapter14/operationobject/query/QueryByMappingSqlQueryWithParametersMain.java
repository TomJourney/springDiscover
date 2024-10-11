package com.tom.springnote.chapter14.operationobject.query;

import com.tom.springnote.chapter14.model.UserDto;
import com.tom.springnote.utils.DataSourceUtils;

import java.util.List;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName QueryByMappingSqlQueryWithParameters.java
 * @Description TODO
 * @createTime 2024年08月28日 17:52:00
 */
public class QueryByMappingSqlQueryWithParametersMain {
    public static void main(String[] args) {
        QueryByMappingSqlQueryWithParameters queryByMappingSqlQueryWithParameters =
                new QueryByMappingSqlQueryWithParameters(DataSourceUtils.getDataSource());
        List<UserDto> resutlList = queryByMappingSqlQueryWithParameters.execute(50000);
        System.out.println(resutlList);
    }
}
