package com.tom.springnote.chpater14.jdbctemplate.exceptiontranslator;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;

import java.rmi.UnexpectedException;
import java.sql.SQLException;
import java.util.Objects;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName CustomSqlExceptionTranslator.java
 * @Description TODO
 * @createTime 2024年08月27日 20:36:00
 */
public class CustomSqlExceptionTranslator extends SQLErrorCodeSQLExceptionTranslator {
    @Override
    protected DataAccessException customTranslate(String task, String sql, SQLException sqlEx) {
        if (Objects.equals(sqlEx.getErrorCode(), "119")) {
            return new BadSqlGrammarException(task, sql, sqlEx);
        }
        return null;
    }
}
