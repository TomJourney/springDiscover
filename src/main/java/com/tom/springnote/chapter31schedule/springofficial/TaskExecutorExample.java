package com.tom.springnote.chapter31schedule.springofficial;

import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.TimeUnit;

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
            System.out.println("线程id=" + Thread.currentThread().getId() + ", message=" + message);
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
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
    // main函数： 案例执行入口
    public static void main(String[] args) {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = buildThreadPoolTaskExecutor();
        new TaskExecutorExample(threadPoolTaskExecutor).printMessages();
        threadPoolTaskExecutor.shutdown();
    }
    private static ThreadPoolTaskExecutor buildThreadPoolTaskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        // 设置属性前，必须先调用initialize()初始化Executor，实际底层调用 ThreadPoolTaskExecutor#initializeExecutor()
        threadPoolTaskExecutor.initialize();
        threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true); // 等待任务执行完成后再关闭执行器
        threadPoolTaskExecutor.setCorePoolSize(2);
        threadPoolTaskExecutor.setMaxPoolSize(3);
        threadPoolTaskExecutor.setKeepAliveSeconds(0);
        threadPoolTaskExecutor.setQueueCapacity(100);
        return threadPoolTaskExecutor;
    }
}
