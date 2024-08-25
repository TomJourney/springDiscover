package com.tom.springnote.chapter11.target;

import org.springframework.util.StringUtils;

import java.io.File;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName BusiFileReader.java
 * @Description TODO
 * @createTime 2024年08月24日 07:26:00
 */
public class UserDAO {

    public String qryUserNameById(String userId) {
        if (!StringUtils.hasText(userId)) {
            throw new RuntimeException("用户id非法");
        }
        System.out.println("UserDAO#qryUserNameById() 方法被调用");
        return "张三" + userId;
    }
}
