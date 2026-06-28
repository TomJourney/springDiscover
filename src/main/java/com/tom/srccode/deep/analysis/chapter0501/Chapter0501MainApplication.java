package com.tom.srccode.deep.analysis.chapter0501;

import com.tom.srccode.deep.analysis.chapter0501.beans.TomAccountService;
import com.tom.srccode.deep.analysis.chapter0501.event.TomEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tom
 * @version 1.0.0
 * @Description TODO
 * @createTime 2026年06月27日 06:44:00
 */
@Slf4j
public class Chapter0501MainApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("/a_src_deep_analysis/chapter05/beans0501.xml");
        TomAccountService tomAccountService = applicationContext.getBean("tomAccountService", TomAccountService.class);
        System.out.println(tomAccountService.getTestStr());
        log.info("tomAccountService = {}", tomAccountService);

        // 发布 TomEvent时间
        applicationContext.publishEvent(new TomEvent("hello", "world"));
    }
}
