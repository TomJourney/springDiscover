package com.tom.springnote.chapter05.chapter0503.customevent;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName MethodExecutionStatus.java
 * @Description 方法执行状态枚举
 * @createTime 2024年08月15日 15:17:00
 */
public enum MethodExecutionStatus {
    BEGIN,
    END;

    public boolean ifBegin() {
        return BEGIN.equals(this);
    }
}
