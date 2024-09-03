package com.tom.springnote.chapter20.declaretx.service;

import com.tom.springnote.common.model.BankCardDto;

import java.util.List;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName IBankCardService.java
 * @Description TODO
 * @createTime 2024年09月01日 17:09:00
 */
public interface IBankCardService {

    BankCardDto queryById(Long id);

    BankCardDto queryByNo(String cardNo);

    void saveBankCard(List<BankCardDto> bankCardDto);

    void updateBankCard(BankCardDto bankCardDto);

    void deleteBankCard(BankCardDto bankCardDto);
}
