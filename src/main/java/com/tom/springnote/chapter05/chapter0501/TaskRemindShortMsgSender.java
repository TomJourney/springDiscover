package com.tom.springnote.chapter05.chapter0501;

import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName TaskRemindShortMsgSender.java
 * @Description 任务提醒短信发送器
 * @createTime 2024年08月15日 14:01:00
 */
public class TaskRemindShortMsgSender {

    /** 短信模版 */
    private Resource template;

    public void send(String username) throws IOException {
        System.out.println("发送短信，内容=" + String.format(template.getContentAsString(StandardCharsets.UTF_8), username));
    }

    public Resource getTemplate() {
        return template;
    }

    public void setTemplate(Resource template) {
        this.template = template;
    }
}
