package com.tom.springnote.chapter20springtx.dao.usertbl;

import com.tom.springnote.common.model.UserDto;
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
public class UserDao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    private static final String NAMESPACE = "com.tom.springnote.chapter20springtx.dao.usertbl.user";

    public UserDto qryUserById(Long id) {
        List<UserDto> resultList = sqlSessionTemplate.selectList(NAMESPACE + ".qryUserById", id);
        if (CollectionUtils.isEmpty(resultList)) {
            return null;
        } else {
            return resultList.get(0);
        }
    }

    public void insertUser(UserDto userDto) {
        System.out.println("=== UserDao#insertUser() begin");
        sqlSessionTemplate.insert(NAMESPACE + ".insertUser", userDto);
        System.out.println("=== UserDao#insertUser() end");
    }


}
