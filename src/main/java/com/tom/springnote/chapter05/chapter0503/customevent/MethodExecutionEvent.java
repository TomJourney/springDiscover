package com.tom.springnote.chapter05.chapter0503.customevent;

import java.util.EventObject;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName CustomSendMsgEvent.java
 * @Description 方法执行事件
 * @createTime 2024年08月15日 15:06:00
 */
public class MethodExecutionEvent extends EventObject {
    private String methodName;
    public MethodExecutionEvent(Object source) {
        super(source);
    }

    public MethodExecutionEvent(Object source, String methodName) {
        super(source);
        this.methodName = methodName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}
