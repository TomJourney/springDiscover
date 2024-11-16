package com.tom.springnote.javabasedcontainer;

import com.tom.springnote.javabasedcontainer.appservice.UserAppService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName AppConfig.java
 * @Description TODO
 * @createTime 2024年10月22日 22:02:00
 */
@Configuration
public class AppConfig {

    @Bean
    public UserAppService userAppService() {
        return new UserAppService();
    }
}
