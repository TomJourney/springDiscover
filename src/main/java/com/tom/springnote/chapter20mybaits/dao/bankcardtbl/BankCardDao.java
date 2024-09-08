package com.tom.springnote.chapter20mybaits.dao.bankcardtbl;

import com.tom.springnote.common.model.BankCardDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName BankCardDao.java
 * @Description TODO
 * @createTime 2024年09月08日 07:56:00
 */
@Repository
public class BankCardDao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    private static final String NAMESPACE = "com.tom.springnote.chapter20mybaits.dao.bankcard";

    public void insertBankCard(BankCardDto bankCardDto) {
        sqlSessionTemplate.insert(NAMESPACE + ".insertBankCard", bankCardDto);
    }

    public BankCardDto qryBankCardById(Long id) {
        List<BankCardDto> resultList = sqlSessionTemplate.selectList(NAMESPACE + ".qryBankCardById", id);
        if (CollectionUtils.isEmpty(resultList)) {
            return null;
        } else {
            return resultList.get(0);
        }
    }
}
