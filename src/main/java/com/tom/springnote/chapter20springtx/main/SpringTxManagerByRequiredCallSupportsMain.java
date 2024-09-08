package com.tom.springnote.chapter20springtx.main;

import com.tom.springnote.chapter20springtx.service.txmanager.SpringTxManagerByRequiredCallNew;
import com.tom.springnote.chapter20springtx.service.txmanager.SpringTxManagerByRequiredCallSupports;
import com.tom.springnote.common.model.UserDto;
import com.tom.springnote.utils.BusiDatetimeUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName SpringTxManagerUserMain.java
 * @Description TODO
 * @createTime 2024年09月08日 14:42:00
 */
public class SpringTxManagerByRequiredCallSupportsMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("chapter20/mybatis/springTxManage.xml");
        SpringTxManagerByRequiredCallSupports userService = container.getBean(SpringTxManagerByRequiredCallSupports.class);
        UserDto userDto = userService.addWithLog(UserDto.newUserDto(BusiDatetimeUtils.getCurYyyyMmDdHhMmSs()));
        if (userDto == null) {
            System.out.println("null");
        } else {
            System.out.println(userDto);
        }
    }
}
