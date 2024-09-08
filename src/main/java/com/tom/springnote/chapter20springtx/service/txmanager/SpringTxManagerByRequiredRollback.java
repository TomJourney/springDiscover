package com.tom.springnote.chapter20springtx.service.txmanager;

import com.tom.springnote.chapter20springtx.service.user.SpringTxUserService;
import com.tom.springnote.chapter20springtx.service.userlog.SpringTxUserLogService;
import com.tom.springnote.common.model.UserDto;
import com.tom.springnote.common.model.UserLogDto;
import com.tom.springnote.utils.BusiDatetimeUtils;
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
public class SpringTxManagerByRequiredRollback {

    @Autowired
    private SpringTxUserService userService;

    @Autowired
    private SpringTxUserLogService userLogService;

    public UserDto addWithLog(UserDto userDto) {
        System.out.println("====== SpringTxManagerByRequiredCallSupportsRollback#addWithLog() begin");
        // 保存用户
        userService.insertUser(userDto);
        // 保存用户日志
        userLogService.insertUserLog(UserLogDto.newUserLogDto(BusiDatetimeUtils.getCurYyyyMmDdHhMmSs(), userDto.getId(), "新增用户"));
        // 查询日志
        UserDto result = userService.qryUserById(userDto.getId());
        System.out.println("====== SpringTxManagerByRequiredCallSupportsRollback#addWithLog() end");
        return result;
    }
}
