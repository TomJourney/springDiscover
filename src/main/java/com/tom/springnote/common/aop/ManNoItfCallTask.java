package com.tom.springnote.common.aop;

import com.tom.springnote.common.aop.BusiMessage;

import java.util.concurrent.TimeUnit;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName ManCallTaskImpl.java
 * @Description TODO
 * @createTime 2024年08月20日 06:19:00
 */
public class ManNoItfCallTask {
    public void call(BusiMessage message) {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            System.out.println("抛出异常");
            throw new RuntimeException(e);
        }
        System.out.println("人工拨打电话#call()： " + message);
    }
}
