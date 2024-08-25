package com.tom.springnote.chapter04.t040303xmlmethodinject;

import com.tom.springnote.chapter04.t0401.INewsPersister;
import com.tom.springnote.chapter04.t0401.NewsDto;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName BeanFactoryAwareNewsPersister.java
 * @Description 实现 BeanFactoryAware
 * @createTime 2024年08月03日 16:32:00
 */
public class MethodReplacerNewsPersister implements INewsPersister {
    private NewsDto newsDto;

    @Override
    public void persistNews() {
        System.out.println("持久化newsDto，newsDto.hashCode=" + getNewsDto().hashCode());
    }

    public NewsDto getNewsDto() {
        return newsDto;
    }

    public void setNewsDto(NewsDto newsDto) {
        this.newsDto = newsDto;
    }
}
