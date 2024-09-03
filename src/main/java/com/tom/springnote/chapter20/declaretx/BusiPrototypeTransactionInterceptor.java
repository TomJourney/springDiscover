package com.tom.springnote.chapter20.declaretx;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.lang.reflect.Method;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName BusiPrototypeTransactionInterceptor.java
 * @Description TODO
 * @createTime 2024年09月01日 15:36:00
 */
public class BusiPrototypeTransactionInterceptor implements MethodInterceptor {

    private PlatformTransactionManager platformTransactionManager;

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method method = invocation.getMethod();
        TransactionDefinition transactionDefinition = buildTransactionDefinition(method);
        TransactionStatus txStatus = platformTransactionManager.getTransaction(transactionDefinition);
        Object result = null;
        try {
            result = invocation.proceed();
        } catch (Throwable t) {
            throw t;
        }
        return null;
    }

    private static TransactionDefinition buildTransactionDefinition(Method method) {
        DefaultTransactionDefinition txDefinition = new DefaultTransactionDefinition();
        txDefinition.setTimeout(30);
        txDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        return txDefinition;
    }

    public PlatformTransactionManager getPlatformTransactionManager() {
        return platformTransactionManager;
    }

    public void setPlatformTransactionManager(PlatformTransactionManager platformTransactionManager) {
        this.platformTransactionManager = platformTransactionManager;
    }
}
