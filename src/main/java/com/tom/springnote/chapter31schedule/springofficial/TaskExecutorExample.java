package com.tom.springnote.chapter31schedule.springofficial;

import org.springframework.core.task.TaskExecutor;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName TaskExecutorExample.java
 * @Description TODO
 * @createTime 2024年10月18日 21:09:00
 */
public class TaskExecutorExample {

    private class MessagePrinterTask implements Runnable {
        private String message;
        public MessagePrinterTask(String message) {
            this.message = message;
        }
        public void run() {
            System.out.println(message);
        }
    }

    private TaskExecutor taskExecutor;
    public TaskExecutorExample(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    public void printMessages() {
        for(int i = 0; i < 25; i++) {
            taskExecutor.execute(new MessagePrinterTask("Message" + i));
        }
    }
}
