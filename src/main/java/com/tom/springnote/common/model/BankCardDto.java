package com.tom.springnote.common.model;

import java.math.BigDecimal;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName BankCardDto.java
 * @Description TODO
 * @createTime 2024年09月01日 10:47:00
 */
public class BankCardDto {

    private Long id;

    private String cardNo;

    private BigDecimal balance;

    private String remark;

    public static BankCardDto newBankCardDto(Long id, String cardNo, BigDecimal balance, String remark) {
        BankCardDto bankCardDto = new BankCardDto();
        bankCardDto.id = id;
        bankCardDto.cardNo = cardNo;
        bankCardDto.balance = balance;
        bankCardDto.remark = remark;
        return bankCardDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankCardDto{" +
                "id=" + id +
                ", cardNo='" + cardNo + '\'' +
                ", balance=" + balance +
                ", remark='" + remark + '\'' +
                '}';
    }
}
