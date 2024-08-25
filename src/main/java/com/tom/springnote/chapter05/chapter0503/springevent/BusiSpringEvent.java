package com.tom.springnote.chapter05.chapter0503.springevent;

import com.tom.springnote.chapter05.chapter0503.customevent.MethodExecutionStatus;
import org.springframework.context.ApplicationEvent;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName CustomSendMsgEvent.java
 * @Description 方法执行事件
 * @createTime 2024年08月15日 15:06:00
 */
public class BusiSpringEvent extends ApplicationEvent {
    private String methodName;
    private MethodExecutionStatus status;

    public BusiSpringEvent(Object source, String methodName, MethodExecutionStatus status) {
        super(source);
        this.methodName = methodName;
        this.status = status;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public MethodExecutionStatus getStatus() {
        return status;
    }

    public void setStatus(MethodExecutionStatus status) {
        this.status = status;
    }
}
