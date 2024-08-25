package com.tom.springnote.chapter08proxypattern.staticproxy;

import com.tom.springnote.chapter08proxypattern.YidongMsgSenderImpl;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName StaticProxyMain.java
 * @Description TODO
 * @createTime 2024年08月17日 07:19:00
 */
public class StaticProxyMain {
    public static void main(String[] args) {
        new StaticProxyMsgSenderImpl(new YidongMsgSenderImpl()).send("您好，您有待办事项需要处理", "123456");
    }
}
