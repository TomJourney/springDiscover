package com.tom.springnote.chapter09.proxyfactory.baseitfproxy;

import com.tom.springnote.common.aop.BusiMessage;
import com.tom.springnote.common.aop.ICallTask;

import java.util.concurrent.TimeUnit;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName MockTaskImpl.java
 * @Description TODO
 * @createTime 2024年08月19日 18:51:00
 */
public class RobotCallTaskImpl implements ICallTask {
    @Override
    public void call(BusiMessage message) {
        System.out.println("机器人拨打电话#call()： " + message);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
