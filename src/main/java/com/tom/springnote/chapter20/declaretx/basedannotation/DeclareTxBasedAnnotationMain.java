package com.tom.springnote.chapter20.declaretx.basedannotation;

import com.tom.springnote.chapter20.declaretx.service.IBankCardService;
import com.tom.springnote.common.model.BankCardDto;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName DeclareTxBasedBeanNameAutoProxyCreatorMain.java
 * @Description TODO
 * @createTime 2024年09月01日 20:00:00
 */
public class DeclareTxBasedAnnotationMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext container =
                new ClassPathXmlApplicationContext("chapter20/factorybean/DeclareTxBasedAnnotation.xml");
        IBankCardService bankCardServiceProxy = container.getBean("bankCardServiceImpl", IBankCardService.class);
        // 查询
        System.out.println(bankCardServiceProxy.queryById(1001L));

        // 新增
        List<BankCardDto> bankCardDtos = List.of(
                BankCardDto.newBankCardDto(1008L, "1008", new BigDecimal("1008"), "备注1008")
                , BankCardDto.newBankCardDto(1009L, "1009", new BigDecimal("1009"), "备注1009"));
        bankCardServiceProxy.saveBankCard(bankCardDtos);

        Transactional a;
    }
}
