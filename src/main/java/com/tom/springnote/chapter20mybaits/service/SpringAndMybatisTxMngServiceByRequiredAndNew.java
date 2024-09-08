package com.tom.springnote.chapter20mybaits.service;

import com.tom.springnote.chapter20mybaits.dao.bankcardtbl.BankCardDao;
import com.tom.springnote.common.model.BankCardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName BankCardServiceImpl.java
 * @Description TODO
 * @createTime 2024年09月01日 17:10:00
 */
@Component("springAndMybatisTxMngServiceByRequiredAndNew")
@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
public class SpringAndMybatisTxMngServiceByRequiredAndNew {

    @Autowired
    private BankCardDao bankCardDao;

    public BankCardDto queryById(Long id) {
        System.out.println("====== queryById begin");
        BankCardDto result = bankCardDao.qryBankCardById(id);
        System.out.println("====== queryById end");
        return result;
    }

    public BankCardDto saveAndQryByPropagation(BankCardDto bankCardDto) {
        System.out.println("====== saveAndQryByPropagation begin");
        this.saveByPropagation(List.of(bankCardDto));
        BankCardDto result = this.queryById(bankCardDto.getId());
        System.out.println("====== saveAndQryByPropagation end");
        return result;
    }

    public void saveByPropagation(List<BankCardDto> bankCardDtoList) {
        System.out.println("====== saveByPropagation begin");
        if (CollectionUtils.isEmpty(bankCardDtoList)) {
            return;
        }
        bankCardDao.insertBankCard(bankCardDtoList.get(0));
        System.out.println("====== saveByPropagation end");
    }
}
