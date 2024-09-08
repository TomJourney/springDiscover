package com.tom.springnote.chapter20mybaits.service;

import com.tom.springnote.chapter20mybaits.dao.bankcardtbl.BankCardDao;
import com.tom.springnote.common.model.BankCardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName BankCardServiceImpl.java
 * @Description TODO
 * @createTime 2024年09月01日 17:10:00
 */
@Component("springAndMybatisTxMngServiceByRequired")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
public class SpringAndMybatisTxMngServiceByRequired {

    @Autowired
    private BankCardDao bankCardDao;

    @Autowired
    private SpringAndMybatisTxMngServiceByRequiredAndNew springAndMybatisTxMngServiceByRequiredAndNew;

    public BankCardDto saveAndQryByPropagation(BankCardDto bankCardDto) {
        System.out.println("====== saveAndQryByPropagation begin");
        this.saveByPropagation(List.of(bankCardDto));
        BankCardDto result = springAndMybatisTxMngServiceByRequiredAndNew.queryById(bankCardDto.getId());
        System.out.println("====== saveAndQryByPropagation end");
        return result;
    }

    public void saveByPropagation(List<BankCardDto> bankCardDtoList) {
        System.out.println("====== saveByPropagation begin");
        bankCardDao.insertBankCard(bankCardDtoList.get(0));
        System.out.println("====== saveByPropagation end");
    }
}
