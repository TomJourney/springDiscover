package com.tom.springnote.chapter04.t0401;

import org.springframework.stereotype.Component;

/**
 * @author TomBrother
 * @version 1.0.0
 * @ClassName BaiduNewsPersister.java
 * @Description TODO
 * @createTime 2024年08月02日
 */
@Component
public class BaiduNewsPersister implements INewsPersister {
    @Override
    public void persistNews(NewsDto newsDto) {
        System.out.println("保存新闻, id=" + newsDto.getNewsId());
    }
}
