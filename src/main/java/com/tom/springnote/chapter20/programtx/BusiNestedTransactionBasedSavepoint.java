package com.tom.springnote.chapter20.programtx;

import com.tom.springnote.common.model.BankCardDto;
import com.tom.springnote.utils.DataSourceUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.function.Consumer;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName BusiNestedTransactionBasedSavepoint.java
 * @Description TODO
 * @createTime 2024年08月31日 07:35:00
 */
public class BusiNestedTransactionBasedSavepoint {
    private JdbcTemplate jdbcTemplate;
    private TransactionTemplate transactionTemplate;

    public BusiNestedTransactionBasedSavepoint() {
        DataSource dataSource = DataSourceUtils.getDataSource();
        // 创建jdbc模版
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        // 创建事务模版
        JdbcTransactionManager jdbcTransactionManager = new JdbcTransactionManager(dataSource);
        DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        defaultTransactionDefinition.setTimeout(20);
        this.transactionTemplate = new TransactionTemplate(jdbcTransactionManager, defaultTransactionDefinition);
    }

    public void update(BankCardDto srcCard, BankCardDto firstCard, BankCardDto secondCard, BigDecimal transferMoney) {
        transactionTemplate.executeWithoutResult(new Consumer<TransactionStatus>() {
            @Override
            public void accept(TransactionStatus txStatus) {
                try {
                    Object savepoint1 = txStatus.createSavepoint();// 创建保存点
                    try {
                        transfer(srcCard, firstCard, transferMoney); // 转账到主卡
                        throw new RuntimeException("mock异常"); // 故意抛出异常
                    } catch (Exception e1) {
                        e1.printStackTrace(); // 仅演示，不要这么做
                        txStatus.rollbackToSavepoint(savepoint1); // 回滚到保存点
                        transfer(srcCard, secondCard, transferMoney); // 转账到副卡
                    } finally {
                        txStatus.releaseSavepoint(savepoint1); // 释放保存点
                    }
                } catch (Exception e2) {
                    System.out.println("抛出异常");
                    e2.printStackTrace(); // 仅演示，不要这么做
                    txStatus.setRollbackOnly(); // 重置rollbackOnly=true，jdbcTransactionManager事务管理器会回滚事务，而不是提交
                }
            }
        });
    }

    private void transfer(BankCardDto srcCard, BankCardDto targetCard, BigDecimal transferMoney) {
        srcCard.setBalance(srcCard.getBalance().subtract(transferMoney));
        targetCard.setBalance(targetCard.getBalance().add(transferMoney));
        jdbcTemplate.update("update bank_card_tbl set balance=? where id=?", srcCard.getBalance(), srcCard.getId());
        jdbcTemplate.update("update bank_card_tbl set balance=? where id=?", targetCard.getBalance(), targetCard.getId());
    }
}
