package com.tom.springnote.chapter10.target;

import com.tom.springnote.common.aop.BusiMessage;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName MessageDAO.java
 * @Description TODO
 * @createTime 2024年08月23日 14:28:00
 */
public class MessageDAO {
    public BusiMessage qryMsg(String msgId) {
        System.out.println("MessageDAO#qryMsg() 被调用");
        return BusiMessage.build(msgId, "您有待办任务需要处理");
    }
}
