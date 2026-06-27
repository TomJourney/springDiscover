package com.tom.srccode.deep.analysis.chapter0501.config;

import com.tom.srccode.deep.analysis.chapter0501.beans.TomAccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tom
 * @version 1.0.0
 * @Description TODO
 * @createTime 2026年06月27日 10:06:00
 */
@Configuration
public class AppConfig {

    @Bean(initMethod = "myInitMethod")
    public TomAccountService tomAccountService() {
        return new TomAccountService();
    }
}
