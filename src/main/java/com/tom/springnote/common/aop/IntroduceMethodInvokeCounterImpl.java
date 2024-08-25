package com.tom.springnote.common.aop;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName MethodInvokeCounterImpl.java
 * @Description TODO
 * @createTime 2024年08月20日 10:48:00
 */
public class IntroduceMethodInvokeCounterImpl implements IIntroduceMethodInvokeCounter {

    private int counter = 0;

    @Override
    public int getCounter() {
        int curCounter = ++counter;
        System.out.printf("方法调用次数=%d\n", curCounter);
        return curCounter;
    }
}
