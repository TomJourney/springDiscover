package com.tom.springnote.chapter04.t040303xmlfactorybean;

import com.tom.springnote.chapter04.t0401.NewsDto;
import org.springframework.beans.factory.FactoryBean;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author TomBrother
 * @version 1.0.0
 * @Description factorybean接口实现类，扩展对象实例化逻辑
 * @createTime 2024年08月01日
 */
public class FactoryBeanInterfaceBean implements FactoryBean<NewsDto> {
    private static final AtomicInteger start = new AtomicInteger(0);

    @Override
    public NewsDto getObject() throws Exception {
        int id = start.getAndIncrement();
        return new NewsDto(""+id, "FactoryBeanInterfaceBean新闻标题" + id);
    }

    @Override
    public Class<?> getObjectType() {
        return NewsDto.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
