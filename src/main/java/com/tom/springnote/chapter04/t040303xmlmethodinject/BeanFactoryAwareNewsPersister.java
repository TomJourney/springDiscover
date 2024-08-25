package com.tom.springnote.chapter04.t040303xmlmethodinject;

import com.tom.springnote.chapter04.t0401.INewsPersister;
import com.tom.springnote.chapter04.t0401.NewsDto;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName BeanFactoryAwareNewsPersister.java
 * @Description 实现 BeanFactoryAware
 * @createTime 2024年08月03日 16:32:00
 */
public class BeanFactoryAwareNewsPersister implements INewsPersister, BeanFactoryAware {
    private BeanFactory beanFactory;
    private NewsDto newsDto;

    @Override
    public void persistNews() {
        System.out.println("持久化newsDto，newsDto.hashCode=" + getNewsDto().hashCode());
    }
    public NewsDto getNewsDto() {
        return beanFactory.getBean("methodInjectNewsDto", NewsDto.class);
    }
    public void setNewsDto(NewsDto newsDto) {
        this.newsDto = newsDto;
    }
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
