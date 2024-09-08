package com.tom.springnote.chapter20mybaits.main;

import com.tom.springnote.chapter20mybaits.service.SpringAndMybatisTxMngServiceByRequired;
import com.tom.springnote.common.model.BankCardDto;
import com.tom.springnote.utils.BusiDatetimeUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName BankCardServiceImpl.java
 * @Description TODO
 * @createTime 2024年09月01日 17:10:00
 */
public class SpringTxMngServiceByRequiredAndNewMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("chapter20/mybatis/springAndMybatisIntegrate.xml");
        SpringAndMybatisTxMngServiceByRequired txMngService = container.getBean(SpringAndMybatisTxMngServiceByRequired.class);
        BankCardDto bankCardDto = txMngService.saveAndQryByPropagation(BankCardDto.newBankCardDto(BusiDatetimeUtils.getCurYyyyMmDdHhMmSs()));
        if (bankCardDto == null) {
            System.out.println("null");
        } else {
            System.out.println(bankCardDto);
        }
    }
}
