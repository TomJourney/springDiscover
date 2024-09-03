package com.tom.springnote.chapter20.declaretx.factorybean;

import com.alibaba.druid.pool.DruidDataSource;
import com.tom.springnote.chapter20.declaretx.service.IBankCardService;
import com.tom.springnote.common.model.BankCardDto;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.interceptor.TransactionAttributeSourceEditor;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName BusiDeclareTransactionBasedFactoryBean.java
 * @Description TODO
 * @createTime 2024年09月01日 17:06:00
 */
public class DeclareTransactionBasedFactoryBeanMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext container =
                new ClassPathXmlApplicationContext("chapter20/factorybean/DeclareTxBasedProxyFactory.xml");
        IBankCardService bankCardServiceProxy = container.getBean("bankCardServiceProxy", IBankCardService.class);
        // 查询
//        System.out.println(bankCardServiceProxy.queryById(1001L));

        // 新增
        List<BankCardDto> bankCardDtos = List.of(
                BankCardDto.newBankCardDto(1004L, "1004", new BigDecimal("1004"), "备注1004")
                , BankCardDto.newBankCardDto(1005L, "1005", new BigDecimal("1005"), "备注1005"));
        bankCardServiceProxy.saveBankCard(bankCardDtos);

        TransactionAttributeSourceEditor b;
    }
}
