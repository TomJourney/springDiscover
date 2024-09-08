package com.tom.springnote.chapter20springtx.service.userlog;

import com.tom.springnote.chapter20springtx.dao.userlogtbl.UserLogDao;
import com.tom.springnote.common.model.UserLogDto;
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
@Service()
public class SpringTxUserLogService {
    @Autowired
    private UserLogDao userLogDao;

    public void insertUserLog(UserLogDto userLogDto) {
        System.out.println("====== SpringTxUserLogService#insertUserLog() begin");
        userLogDto.setLogInfo("123456789123456789123"); // 故意设置21位的logInfo，以便sql异常(log_info数据库表定义为20字符长度)
        userLogDao.insertUserLog(userLogDto);
        System.out.println("====== SpringTxUserLogService#insertUserLog() end");
    }
}
