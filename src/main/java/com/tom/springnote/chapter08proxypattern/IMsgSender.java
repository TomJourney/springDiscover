package com.tom.springnote.chapter08proxypattern;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName IMsgSendSupport.java
 * @Description TODO
 * @createTime 2024年08月17日 07:17:00
 */
public interface IMsgSender {

    void send(String msg, String phoneNum);

    default boolean checkAuth(String phoneNum) {
        System.out.printf("IMsgSender#checkAuth()： 校验权限； 电话号码：[%s]\n", phoneNum);
        return false;
    }
}
