package com.tom.springnote.chpater14.operationobject.query;

import com.tom.springnote.chpater14.model.UserDto;
import com.tom.springnote.utils.DataSourceUtils;

import java.util.List;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName BusiMappingSqlQueryMain.java
 * @Description TODO
 * @createTime 2024年08月28日 19:18:00
 */
public class BusiMappingSqlQueryMain {
    public static void main(String[] args) {
        BusiMappingSqlQuery busiMappingSqlQuery = new BusiMappingSqlQuery(DataSourceUtils.getDataSource());
        List<UserDto> resutlList = busiMappingSqlQuery.execute(50000);
        System.out.println(resutlList);
    }
}
