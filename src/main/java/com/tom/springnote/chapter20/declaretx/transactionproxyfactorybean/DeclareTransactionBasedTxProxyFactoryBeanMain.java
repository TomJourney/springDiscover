package com.tom.springnote.chapter20.declaretx.transactionproxyfactorybean;

import com.tom.springnote.chapter20.declaretx.service.IBankCardService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName BusiTransactionProxyFactoryBean.java
 * @Description TODO
 * @createTime 2024年09月01日 19:43:00
 */
public class DeclareTransactionBasedTxProxyFactoryBeanMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext container =
                new ClassPathXmlApplicationContext("chapter20/factorybean/DeclareTxBasedTransactionProxyFactoryBean.xml");
        IBankCardService bankCardServiceProxy = container.getBean("bankCardServiceProxy", IBankCardService.class);
        // 查询
        System.out.println(bankCardServiceProxy.queryById(1001L));
    }
}
