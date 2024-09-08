package com.tom.springnote.chapter20springtx.service.user;

import com.tom.springnote.chapter20springtx.dao.usertbl.UserDao;
import com.tom.springnote.common.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName UserService.java
 * @Description TODO
 * @createTime 2024年09月08日 14:35:00
 */
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
@Service
public class SpringTxUserService {

    @Autowired
    private UserDao userDao;

    public void insertUser(UserDto userDto) {
        System.out.println("====== SpringTxUserService#insertUser() begin");
        userDao.insertUser(userDto);
        System.out.println("====== SpringTxUserService#insertUser() end");
    }

    public UserDto qryUserById(Long id) {
        System.out.println("====== SpringTxUserService#qryUserById() begin");
        UserDto result = userDao.qryUserById(id);
        System.out.println("====== SpringTxUserService#qryUserById() end");
        return result;
    }
}
