package com.tom.springnote.chapter20springtx.dao.userlogtbl;

import com.tom.springnote.common.model.UserLogDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName BankCardDao.java
 * @Description TODO
 * @createTime 2024年09月08日 07:56:00
 */
@Repository
public class UserLogDao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    private static final String NAMESPACE = "com.tom.springnote.chapter20springtx.dao.userlogtbl.userlog";

    public void insertUserLog(UserLogDto userLogDto) {
        sqlSessionTemplate.insert(NAMESPACE + ".insertUserLog", userLogDto);
    }

}
