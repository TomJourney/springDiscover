package com.tom.springsourcecode.config;

import com.tom.springsourcecode.service.HelloService02;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName AppConfig00.java
 * @Description TODO
 * @createTime 2024年10月23日 06:35:00
 */
@Configuration
public class AppConfig02 {

    public AppConfig02() {
        System.out.println("AppConfig02 构造器");
    }

    @Bean
    public HelloService02 helloService02() {
        return new HelloService02();
    }
}
