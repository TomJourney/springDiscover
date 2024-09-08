package com.tom.springnote.chapter20.declaretx.service.propagation;

import com.tom.springnote.chapter20.declaretx.service.AbstractBankCardService;
import com.tom.springnote.chapter20.declaretx.service.IBankCardService;
import com.tom.springnote.common.model.BankCardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
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
@Component("BankCardServiceImplByPropagationRequired")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class BankCardServiceImplByPropagationRequired extends AbstractBankCardService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("bankCardServiceImplByPropagationRequiredAndNew")
    private IBankCardService bankCardServiceImplByPropagationRequiredAndNew;

    public BankCardServiceImplByPropagationRequired(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public BankCardDto saveAndQryByPropagation(BankCardDto bankCardDto) {
        this.doSaveBankCard(List.of(bankCardDto));
        return bankCardServiceImplByPropagationRequiredAndNew.queryById(bankCardDto.getId());
    }

    private void doSaveBankCard(List<BankCardDto> bankCardDtoList) {
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
