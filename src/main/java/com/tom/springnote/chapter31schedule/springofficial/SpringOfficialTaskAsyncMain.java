package com.tom.springnote.chapter31schedule.springofficial;

import com.tom.springnote.chapter31schedule.springofficial.task.TomDiyAsyncTask;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName TomSpringOfficialTaskScheduleMain.java
 * @Description TODO
 * @createTime 2024年10月19日 21:55:00
 */
public class SpringOfficialTaskAsyncMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext springContainer =
                new ClassPathXmlApplicationContext("chapter31schedule/spring-official-async.xml");
        TomDiyAsyncTask tomDiyAsyncTask = springContainer.getBean(TomDiyAsyncTask.class);
        tomDiyAsyncTask.asyncDoBusi();
        System.out.println("main(): 线程id=" + Thread.currentThread().getId());
        // 关闭线程池
        ThreadPoolTaskExecutor threadPoolTaskExecutor = (ThreadPoolTaskExecutor) springContainer.getBean("myExecutor");
        threadPoolTaskExecutor.shutdown();
        springContainer.registerShutdownHook();
    }
}
