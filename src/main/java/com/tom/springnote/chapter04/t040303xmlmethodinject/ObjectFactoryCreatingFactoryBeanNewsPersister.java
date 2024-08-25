package com.tom.springnote.chapter04.t040303xmlmethodinject;

import com.tom.springnote.chapter04.t0401.INewsPersister;
import com.tom.springnote.chapter04.t0401.NewsDto;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName ObjectFactoryCreatingFactoryBeanNewsPersister.java
 * @Description 通过 ObjectFactory 实现方法注入
 * @createTime 2024年08月03日 16:52:00
 */
public class ObjectFactoryCreatingFactoryBeanNewsPersister implements INewsPersister {
    private ObjectFactory<NewsDto> objectFactory;
    private NewsDto newsDto;

    @Override
    public void persistNews() {
        System.out.println("持久化newsDto，newsDto.hashCode=" + getNewsDto().hashCode());
    }
    public NewsDto getNewsDto() {
        return objectFactory.getObject();
    }
    public void setNewsDto(NewsDto newsDto) {
        this.newsDto = newsDto;
    }
    public void setObjectFactory(ObjectFactory<NewsDto> objectFactory) {
        this.objectFactory = objectFactory;
    }
}
