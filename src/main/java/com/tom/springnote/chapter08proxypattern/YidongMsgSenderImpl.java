package com.tom.springnote.chapter08proxypattern;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName YidongMsgSendSupportImpl.java
 * @Description TODO
 * @createTime 2024年08月17日 07:18:00
 */
public class YidongMsgSenderImpl implements IMsgSender {

    @Override
    public void send(String msg, String phoneNum) {
        System.out.printf("运营商：[中国移动]，短信内容：[%s] ； 电话号码：[%s] \n", msg, phoneNum);
    }
}
