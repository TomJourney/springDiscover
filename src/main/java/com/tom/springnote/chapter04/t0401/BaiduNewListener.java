package com.tom.springnote.chapter04.t0401;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author TomBrother
 * @version 1.0.0
 * @ClassName BaiduNewListener.java
 * @Description TODO
 * @createTime 2024年08月02日
 */
@Component
public class BaiduNewListener implements INewsListener {
    Map<String, NewsDto> newsContainer = new HashMap<>(10);

    public BaiduNewListener() {
        newsContainer.put("1", new NewsDto("1", "百度新闻1号"));
        newsContainer.put("2", new NewsDto("2", "百度新闻2号"));
        newsContainer.put("3", new NewsDto("3", "百度新闻3号"));
    }

    @Override
    public String[] getAvailableNewsIds() {
        return newsContainer.keySet().toArray(new String[0]);
    }

    @Override
    public NewsDto getNewsByPk(String newsId) {
        return newsContainer.get(newsId);
    }

    @Override
    public void postProcessIfNeed(String newsId) {

    }

    @Override
    public String getListenerId() {
        return String.valueOf(hashCode());
    }
}
