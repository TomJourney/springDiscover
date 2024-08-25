package com.tom.springnote.common.aop;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName MethodAccessLogImpl.java
 * @Description TODO
 * @createTime 2024年08月20日 11:18:00
 */
public class IntroduceMethodAccessLogImpl implements IIntroduceMethodAccessLog {
    @Override
    public void sendAccessLog() {
        System.out.println("MethodAccessLogImpl#sendAccessLog(): 发送访问日志");
    }
}
