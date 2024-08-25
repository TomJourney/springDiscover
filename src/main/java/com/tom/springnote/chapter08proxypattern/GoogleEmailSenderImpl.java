package com.tom.springnote.chapter08proxypattern;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName GoogleEmailSenderImpl.java
 * @Description TODO
 * @createTime 2024年08月17日 09:15:00
 */
public class GoogleEmailSenderImpl implements IEmailSender {
    @Override
    public void send(String content, String addr) {
        System.out.printf("发送邮件： 内容=[%s]， 邮箱地址=[%s]\n", content, addr);
    }
}
