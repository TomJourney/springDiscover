package com.tom.springnote.chapter20.declaretx.service;

import com.tom.springnote.common.model.BankCardDto;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName BankCardServiceImpl.java
 * @Description TODO
 * @createTime 2024年09月01日 17:10:00
 */
@Transactional
public class BankCardServiceImplAnnotationed implements IBankCardService {

    private JdbcTemplate jdbcTemplate;

    public BankCardServiceImplAnnotationed(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true,timeout = 20)
    @Override
    public BankCardDto queryById(Long id) {
        String sql = "select id, card_no, balance, remark from bank_card_tbl where id = ?";
        return jdbcTemplate.queryForObject(sql, new RowMapper<>() {
            @Override
            public BankCardDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                BankCardDto bankCardDto = new BankCardDto();
                bankCardDto.setId(rs.getLong(1));
                bankCardDto.setCardNo(rs.getString(2));
                bankCardDto.setBalance(rs.getBigDecimal(3));
                bankCardDto.setRemark(rs.getString(4));
                return bankCardDto;
            }
        }, id);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true,timeout = 20)
    @Override
    public BankCardDto queryByNo(String cardNo) {
        return null;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveBankCard(List<BankCardDto> bankCardDtoList) {
        if (CollectionUtils.isEmpty(bankCardDtoList)) {
            return ;
        }
        String sql = "insert into bank_card_tbl(id, card_no, balance, remark) values(?, ?, ?, ?)";
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                BankCardDto bankCardDto = bankCardDtoList.get(i);
                ps.setLong(1, bankCardDto.getId());
                ps.setString(2, bankCardDto.getCardNo());
                ps.setBigDecimal(3, bankCardDto.getBalance());
                ps.setString(4, bankCardDto.getRemark());
            }

            @Override
            public int getBatchSize() {
                return bankCardDtoList.size();
            }
        });
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateBankCard(BankCardDto bankCardDto) {

    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void deleteBankCard(BankCardDto bankCardDto) {

    }
}
