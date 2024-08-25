package com.tom.springnote.chapter10.introductionadviceannotation;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName AccessLogImpl.java
 * @Description TODO
 * @createTime 2024年08月23日 15:39:00
 */
public class AccessLogImpl implements IAccessLog {
    @Override
    public void sendAccessLog() {
        System.out.println("AccessLogImpl#sendAccessLog(): 发送访问日志");
    }
}
