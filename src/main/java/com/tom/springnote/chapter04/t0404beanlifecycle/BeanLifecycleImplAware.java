package com.tom.springnote.chapter04.t0404beanlifecycle;

import org.springframework.beans.BeansException;
import org.springframework.context.*;
import org.springframework.core.io.ResourceLoader;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName BeanLifecycleImplAware.java
 * @Description TODO
 * @createTime 2024年08月04日 20:31:00
 */
public class BeanLifecycleImplAware implements ResourceLoaderAware, ApplicationEventPublisher, MessageSourceAware, ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }

    @Override
    public void publishEvent(Object event) {

    }

    @Override
    public void setMessageSource(MessageSource messageSource) {

    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {

    }
}
