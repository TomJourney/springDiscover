package com.tom.springnote.chapter08proxypattern.dynamicbytegen;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName TaskSender.java
 * @Description TODO
 * @createTime 2024年08月17日 09:36:00
 */
public class BusiTarget {

    public void send1(String content, String taskId) {
        System.out.printf("BusiTarget#send1()： 发送任务，内容=[%s], taskId=[%s]\n", content, taskId);
    }

    public void send2(String content, String taskId) {
        System.out.printf("BusiTarget#send2()： 发送任务，内容=[%s], taskId=[%s]\n", content, taskId);
    }
}
