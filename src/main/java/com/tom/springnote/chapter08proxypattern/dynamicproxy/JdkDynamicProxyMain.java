package com.tom.springnote.chapter08proxypattern.dynamicproxy;

import com.tom.springnote.chapter08proxypattern.GoogleEmailSenderImpl;
import com.tom.springnote.chapter08proxypattern.IEmailSender;
import com.tom.springnote.chapter08proxypattern.IMsgSender;
import com.tom.springnote.chapter08proxypattern.YidongMsgSenderImpl;

import java.lang.reflect.Proxy;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName DynamicProxyMain.java
 * @Description TODO
 * @createTime 2024年08月17日 07:26:00
 */
public class JdkDynamicProxyMain {
    public static void main(String[] args) {
        // 发送短信动态代理
        IMsgSender msgSenderTarget = new YidongMsgSenderImpl();
        IMsgSender dynamicProxyMsgSender = (IMsgSender) Proxy.newProxyInstance(
                msgSenderTarget.getClass().getClassLoader(), new Class[]{IMsgSender.class}, new SenderInvocationHandler(msgSenderTarget));
        String message = "您好，您有待办任务需要处理";
        String phoneNum = "123456";
        dynamicProxyMsgSender.checkAuth(phoneNum);
        dynamicProxyMsgSender.send(message, phoneNum);

        System.out.println("\n我是分割线=================\n");
        // 发送邮箱动态代理
        IEmailSender emailSenderTarget = new GoogleEmailSenderImpl();
        IEmailSender dynamicProxyEmailSender = (IEmailSender) Proxy.newProxyInstance(
                emailSenderTarget.getClass().getClassLoader(), new Class[]{IEmailSender.class}, new SenderInvocationHandler(emailSenderTarget));
        dynamicProxyEmailSender.checkAuth("123@gamil.com");
        dynamicProxyEmailSender.send(message, "123@gamil.com");
    }
}
