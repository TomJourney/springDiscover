package com.tom.springnote.chapter08proxypattern;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName IEmailSender.java
 * @Description TODO
 * @createTime 2024年08月17日 09:15:00
 */
public interface IEmailSender {

    void send(String content, String addr);

    default boolean checkAuth(String addr) {
        System.out.printf("IEmailSender#checkAuth()： 校验权限； 邮箱地址：[%s]\n", addr);
        return false;
    }
}
