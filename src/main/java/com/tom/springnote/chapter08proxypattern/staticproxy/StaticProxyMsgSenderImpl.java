package com.tom.springnote.chapter08proxypattern.staticproxy;

import com.tom.springnote.chapter08proxypattern.IMsgSender;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName StaticProxyMsgSendImpl.java
 * @Description TODO
 * @createTime 2024年08月17日 07:20:00
 */
public class StaticProxyMsgSenderImpl implements IMsgSender {

    private IMsgSender msgSendSupport;

    public StaticProxyMsgSenderImpl(IMsgSender msgSendSupport) {
        this.msgSendSupport = msgSendSupport;
    }

    @Override
    public void send(String msg, String phoneNum) {
        System.out.println("static proxy busi: before");
        msgSendSupport.send(msg, phoneNum);
        System.out.println("static proxy busi: after");
    }
}
