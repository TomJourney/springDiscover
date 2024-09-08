package com.tom.springnote.chapter19;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.SavepointManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.TransactionAttribute;
import org.springframework.transaction.jta.JtaTransactionManager;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.transaction.Transaction;
import javax.transaction.TransactionSynchronizationRegistry;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName PlatFormTransactionManagerMain.java
 * @Description TODO
 * @createTime 2024年08月29日 21:25:00
 */
public class PlatFormTransactionManagerMain {

    public static void main(String[] args) {
        PlatformTransactionManager a;

        TransactionDefinition b;

        TransactionStatus c;

        DefaultTransactionDefinition d;

        DefaultTransactionDefinition e;

        TransactionAttribute f;

        TransactionStatus g;

        SavepointManager h;

        JtaTransactionManager aa;

        DataSourceTransactionManager bb;

        Transaction cc;

        TransactionSynchronization dd;

        TransactionSynchronizationManager ee;

        TransactionSynchronizationRegistry f1;


    }
}
