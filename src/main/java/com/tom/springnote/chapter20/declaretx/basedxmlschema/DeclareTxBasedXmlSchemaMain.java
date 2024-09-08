package com.tom.springnote.chapter20.declaretx.basedxmlschema;

import com.tom.springnote.chapter20.declaretx.service.IBankCardService;
import com.tom.springnote.common.model.BankCardDto;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName DeclareTxBasedBeanNameAutoProxyCreatorMain.java
 * @Description TODO
 * @createTime 2024年09月01日 20:00:00
 */
public class DeclareTxBasedXmlSchemaMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext container =
                new ClassPathXmlApplicationContext("chapter20/factorybean/DeclareTxBasedXmlSchema.xml");
        IBankCardService bankCardServiceProxy = container.getBean("bankCardServiceImpl", IBankCardService.class);
        // 查询
        System.out.println(bankCardServiceProxy.queryById(1001L));

        // 新增
        saveBankCard(bankCardServiceProxy, 2003);
        saveBankCard(bankCardServiceProxy, 2001);
    }

    private static void saveBankCard(IBankCardService bankCardServiceProxy, long id) {
        String idStr = String.valueOf(id);
        bankCardServiceProxy.saveByPropagation(
                List.of(BankCardDto.newBankCardDto(id, idStr, new BigDecimal(idStr), "备注" + idStr)));
    }
}
