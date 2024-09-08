package com.tom.springnote.chapter20.declaretx.service;

import com.tom.springnote.common.model.BankCardDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName BankCardServiceImpl.java
 * @Description TODO
 * @createTime 2024年09月01日 17:10:00
 */
@Component("bankCardServiceImplAnnotationed")
public class BankCardServiceImplAnnotationed extends AbstractBankCardService {

    private JdbcTemplate jdbcTemplate;

    public BankCardServiceImplAnnotationed(JdbcTemplate jdbcTemplate) {
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
}
