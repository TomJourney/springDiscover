package com.tom.springnote.chapter04.t040303xmlfactorybean;

import com.tom.springnote.chapter04.t0401.NewsDto;

import java.util.concurrent.atomic.AtomicInteger;

public class NewsDtoNonStaticfactory {
    private static final AtomicInteger start = new AtomicInteger(0);

    public NewsDto getInstance() {
        System.out.println("通过非静态工厂[NewsDtoNonStaticfactory]获取bean");
        int id = start.getAndIncrement();
        return new NewsDto(""+id, "新闻标题" + id);
    }
}