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

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName BusiNestedTransactionBasedSavepoint.java
 * @Description TODO
 * @createTime 2024年08月31日 07:35:00
 */
public class BusiNestedTransactionBasedSavepointMain {
    public static void main(String[] args) {
        BusiNestedTransactionBasedSavepoint busiNestedTransactionBasedSavepoint
                = new BusiNestedTransactionBasedSavepoint();
        BankCardDto srcCard = BankCardDto.newBankCardDto(1000L, "1000", new BigDecimal(50), "");
        BankCardDto firstCard = BankCardDto.newBankCardDto(1001L, "1001", new BigDecimal(150), "");
        BankCardDto secondCard = BankCardDto.newBankCardDto(1002L, "1002", new BigDecimal(100), "");
        busiNestedTransactionBasedSavepoint.update(srcCard, firstCard, secondCard, new BigDecimal("50"));
    }
}
