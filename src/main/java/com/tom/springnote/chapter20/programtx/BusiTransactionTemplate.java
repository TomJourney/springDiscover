package com.tom.springnote.chapter20.programtx;

import com.tom.springnote.utils.DataSourceUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.util.function.Consumer;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName BusiTransactionTemplate.java
 * @Description TODO
 * @createTime 2024年08月30日 19:56:00
 */
public class BusiTransactionTemplate {

    private JdbcTemplate jdbcTemplate;
    private TransactionTemplate transactionTemplate;

    public BusiTransactionTemplate() {
        DataSource dataSource = DataSourceUtils.getDataSource();
        // 创建jdbc模版
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        // 创建事务模版
        JdbcTransactionManager jdbcTransactionManager = new JdbcTransactionManager(dataSource);
        DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        defaultTransactionDefinition.setTimeout(20);
        this.transactionTemplate = new TransactionTemplate(jdbcTransactionManager, defaultTransactionDefinition);
    }

    public void update(Long id, String name) {
        Object result = transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                try {
                    return jdbcTemplate.update("update user_tbl set name=? where id=?", name, id);
                } catch (Exception e) {
                    status.setRollbackOnly();
                }
                return -1;
            }
        });
    }

    public void updateWithoutResult(Long id, String name) {
        transactionTemplate.executeWithoutResult(new Consumer<TransactionStatus>() {
            @Override
            public void accept(TransactionStatus transactionStatus) {
                try {
                    jdbcTemplate.update("update user_tbl set name=? where id=?", name, id);
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                }
            }
        });
    }
}
