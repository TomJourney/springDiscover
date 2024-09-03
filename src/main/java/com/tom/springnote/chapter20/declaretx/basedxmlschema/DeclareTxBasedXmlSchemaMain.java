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
        List<BankCardDto> bankCardDtos = List.of(
                BankCardDto.newBankCardDto(1006L, "1006", new BigDecimal("1006"), "备注1006")
                , BankCardDto.newBankCardDto(1007L, "1007", new BigDecimal("1007"), "备注1007"));
        bankCardServiceProxy.saveBankCard(bankCardDtos);
    }
}
