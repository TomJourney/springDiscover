package com.tom.springnote.chapter20.declaretx.service.propagation;

import com.tom.springnote.chapter20.declaretx.service.AbstractBankCardService;
import com.tom.springnote.common.model.BankCardDto;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
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
@Component("bankCardServiceImplByPropagationRequiredAndNew")
@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
public class BankCardServiceImplByPropagationRequiredAndNew extends AbstractBankCardService {

    private JdbcTemplate jdbcTemplate;

    public BankCardServiceImplByPropagationRequiredAndNew(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

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

    @Override
    public BankCardDto saveAndQryByPropagation(BankCardDto bankCardDto) {
        this.saveByPropagation(List.of(bankCardDto));
        return this.queryById(bankCardDto.getId());
    }

    @Override
    public void saveByPropagation(List<BankCardDto> bankCardDtoList) {
        if (CollectionUtils.isEmpty(bankCardDtoList)) {
            return;
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
}
