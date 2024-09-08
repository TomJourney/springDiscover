package com.tom.springnote.chapter20.declaretx.basedannotation;

import com.tom.springnote.chapter20.declaretx.service.IBankCardService;
import com.tom.springnote.common.model.BankCardDto;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.TransactionStatus;

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
        IBankCardService bankCardServiceProxy = container.getBean("bankCardServiceImplAnnotationed", IBankCardService.class);

        // 新增
        bankCardServiceProxy.saveByPropagation(List.of(BankCardDto.newBankCardDto(3001L)));
        TransactionStatus a ;
    }

    private void f1() {

    }
}
