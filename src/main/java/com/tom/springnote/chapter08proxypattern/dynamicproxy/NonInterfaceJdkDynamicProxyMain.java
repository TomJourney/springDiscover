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
public class NonInterfaceJdkDynamicProxyMain {
    public static void main(String[] args) {
        // 发送邮箱动态代理
        GoogleEmailSenderImpl emailSenderTarget = new GoogleEmailSenderImpl();
        GoogleEmailSenderImpl dynamicProxyEmailSender = (GoogleEmailSenderImpl) Proxy.newProxyInstance(
                emailSenderTarget.getClass().getClassLoader(), new Class[]{GoogleEmailSenderImpl.class}, new SenderInvocationHandler(emailSenderTarget));
        dynamicProxyEmailSender.checkAuth("123@gamil.com");
        dynamicProxyEmailSender.send("您好，您有待办任务需要处理", "123@gamil.com");
    }
}
