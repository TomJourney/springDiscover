package com.tom.springnote.chapter14.datasource;

import org.springframework.jdbc.datasource.AbstractDataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName CustomDataSource.java
 * @Description TODO
 * @createTime 2024年08月28日 17:10:00
 */
public class CustomDataSource {
    static class InnerCustomDataSource extends AbstractDataSource {
        @Override
        public Connection getConnection() throws SQLException {
            return null;
        }
        @Override
        public Connection getConnection(String username, String password) throws SQLException {
            return null;
        }
    }

    static class InnerCustomDataSource2 extends AbstractRoutingDataSource {
        @Override
        protected Object determineCurrentLookupKey() {
            return null;
        }
    }
}
