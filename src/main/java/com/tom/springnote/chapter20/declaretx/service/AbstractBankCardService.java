package com.tom.springnote.chapter20.declaretx.service;

import com.tom.springnote.common.model.BankCardDto;

import java.util.List;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName AbstractBankCardService.java
 * @Description TODO
 * @createTime 2024年09月05日 06:36:00
 */
public abstract class AbstractBankCardService implements IBankCardService {
    @Override
    public BankCardDto queryById(Long id) {
        return null;
    }

    @Override
    public BankCardDto queryByNo(String cardNo) {
        return null;
    }

    @Override
    public void saveByPropagation(List<BankCardDto> bankCardDtoList) {

    }



    @Override
    public BankCardDto saveAndQryByPropagation(BankCardDto bankCardDto) {
        return null;
    }

    @Override
    public void updateBankCard(BankCardDto bankCardDto) {

    }

    @Override
    public void deleteBankCard(BankCardDto bankCardDto) {

    }
}
