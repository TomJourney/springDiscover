package com.tom.springnote.chapter04.t040303xmlfactorybean;

import com.tom.springnote.chapter04.t0401.NewsDto;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author TomBrother
 * @version 1.0.0
 * @ClassName NewsDtoStaticfactory.java
 * @Description 新闻dto静态工厂
 * @createTime 2024年08月15日
 */
public class NewsDtoStaticfactory {
    private static final AtomicInteger start = new AtomicInteger(0);

    public static NewsDto getInstance() {
        System.out.println("通过静态工厂获取bean");
        int id = start.getAndIncrement();
        return new NewsDto(""+id, "新闻标题" + id);
    }
}
