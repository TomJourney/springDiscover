package com.tom.springnote.chapter20.declaretx.basedannotation;

import com.tom.springnote.chapter20.declaretx.service.AbstractBankCardService;
import com.tom.springnote.chapter20.declaretx.service.IBankCardService;
import com.tom.springnote.common.model.BankCardDto;
import com.tom.springnote.utils.BusiDatetimeUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Objects;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName BankCardServiceImpl.java
 * @Description TODO
 * @createTime 2024年09月01日 17:10:00
 */
public class BankCardServiceImplByPropagationRequiredNewMain extends AbstractBankCardService {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext container =
                new ClassPathXmlApplicationContext("chapter20/factorybean/DeclareTxBasedAnnotation.xml");
        IBankCardService bankCardServiceProxy = container.getBean("bankCardServiceImplByPropagationRequiredAndNew", IBankCardService.class);

        // 新增
        BankCardDto result = bankCardServiceProxy.saveAndQryByPropagation(BankCardDto.newBankCardDto(BusiDatetimeUtils.getCurYyyyMmDdHhMmSs()));
        if (Objects.isNull(result)) {
            System.out.println("BankCardServiceImplByPropagationRequiredNewMain null");
        } else {
            System.out.println(result);
        }
    }
}
