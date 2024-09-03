package com.tom.springnote.chapter20.programtx;

import com.tom.springnote.utils.DataSourceUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName BusiPlatformTransactionManager.java
 * @Description TODO
 * @createTime 2024年08月30日 17:23:00
 */
public class BusiPlatformTransactionManager {
    private PlatformTransactionManager jdbcTransactionManager;
    private JdbcTemplate jdbcTemplate;
    private DefaultTransactionDefinition defaultTransactionDefinition;

    public BusiPlatformTransactionManager() {
        DataSource dataSource = DataSourceUtils.getDataSource();
        this.jdbcTransactionManager = new JdbcTransactionManager(dataSource);
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.defaultTransactionDefinition = new DefaultTransactionDefinition();
        this.defaultTransactionDefinition.setTimeout(20);
    }
    public void update(Long id, String newName) {
        // 获取连接
        TransactionStatus txStatus = jdbcTransactionManager.getTransaction(defaultTransactionDefinition);
        try {
            jdbcTemplate.update("update user_tbl set name=? where id=?", new PreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps) throws SQLException {
                    ps.setString(1, newName);
                    ps.setLong(2, id);
                }
            });
            jdbcTransactionManager.commit(txStatus); // 提交事务
        } catch (Exception e) {
            jdbcTransactionManager.rollback(txStatus); // 回滚事务
            e.printStackTrace(); // 仅演示，不要这么做
        }
    }
}
