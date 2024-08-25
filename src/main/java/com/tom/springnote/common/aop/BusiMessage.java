package com.tom.springnote.common.aop;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName BusiMessage.java
 * @Description TODO
 * @createTime 2024年08月19日 19:08:00
 */
public class BusiMessage {

    private String msgId;

    private String msgText;

    public BusiMessage() {
        // do nothing.
    }

    public static BusiMessage build(String msgId, String msgText) {
        BusiMessage busiMessage = new BusiMessage();
        busiMessage.msgId = msgId;
        busiMessage.msgText = msgText;
        return busiMessage;
    }

    public String getMsgId() {
        return msgId;
    }

    public String getMsgText() {
        return msgText;
    }

    @Override
    public String toString() {
        return "BusiMessage{" +
                "msgId='" + msgId + '\'' +
                ", msgText='" + msgText + '\'' +
                '}';
    }
}
