package com.tom.springnote.chapter20springtx.service.txmanager;

import com.tom.springnote.chapter20springtx.dao.usertbl.UserDao;
import com.tom.springnote.chapter20springtx.service.user.SpringTxUserService;
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
public class SpringTxManagerByRequiredCallSupports {

    @Autowired
    private SpringTxUserService userService;

    @Autowired
    private UserDao userDao;

    public UserDto addWithLog(UserDto userDto) {
        System.out.println("====== SpringTxManagerByRequiredCallNew#addWithLog() begin");
        // 保存用户
        userDao.insertUser(userDto);
        // 查询
        UserDto result = userService.qryUserById(userDto.getId());
        System.out.println("====== SpringTxManagerByRequiredCallNew#addWithLog() end");
        return result;
    }
}
