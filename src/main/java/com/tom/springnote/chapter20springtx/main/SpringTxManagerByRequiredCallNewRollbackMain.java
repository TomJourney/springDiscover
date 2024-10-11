package com.tom.springnote.chapter20springtx.main;

import com.tom.springnote.chapter20springtx.service.txmanager.SpringTxManagerByRequiredRollback;
import com.tom.springnote.common.model.UserDto;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName SpringTxManagerUserMain.java
 * @Description TODO
 * @createTime 2024年09月08日 14:42:00
 */
public class SpringTxManagerByRequiredCallNewRollbackMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("chapter20/mybatis/springTxManage.xml");
        SpringTxManagerByRequiredRollback userService = container.getBean(SpringTxManagerByRequiredRollback.class);
        UserDto userDto = userService.addWithLog(UserDto.newUserDto(2024090890002L));
        if (userDto == null) {
            System.out.println("null");
        } else {
            System.out.println(userDto);
        }
    }
}
