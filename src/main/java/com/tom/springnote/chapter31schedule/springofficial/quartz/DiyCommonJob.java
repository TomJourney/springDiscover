package com.tom.springnote.chapter31schedule.springofficial.quartz;

import com.tom.springnote.utils.BusiDatetimeUtils;

import java.util.concurrent.TimeUnit;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName DiyCommonJob.java
 * @Description TODO
 * @createTime 2024年10月20日 11:04:00
 */
public class DiyCommonJob {

    public void printNow() {
        System.out.printf("DiyCommonJob#printNow(): 线程id=%s 当前时间=%s \n", Thread.currentThread().getId(), BusiDatetimeUtils.getNowText());
    }
}
