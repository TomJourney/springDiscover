package com.tom.springnote.chapter04.t0401;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author TomBrother
 * @version 1.0.0
 * @ClassName FXNewsProvider.java
 * @Description 新闻
 * @createTime 2024年08月02日
 */
@Component
public class NewsProvider {

    @Autowired
    private INewsListener newsListener;
    @Autowired
    private INewsPersister newsPersister;

    public NewsProvider() {
        System.out.println("NewsProvider无参构造器");
    }

    public NewsProvider(INewsListener newsListener, INewsPersister newsPersister) {
        this.newsListener = newsListener;
        this.newsPersister = newsPersister;
        System.out.println("NewsProvider有参构造器");
    }

    public void getAndPersistNews() {
        String[] newsIds = newsListener.getAvailableNewsIds();
        for (String newsId : newsIds) {
            NewsDto newsBean = newsListener.getNewsByPk(newsId);
            newsPersister.persistNews(newsBean);
            newsListener.postProcessIfNeed(newsId);
        }
    }

    public void setNewsListener(INewsListener newsListener) {
        this.newsListener = newsListener;
    }

    public void setNewsPersister(INewsPersister newsPersister) {
        this.newsPersister = newsPersister;
    }
}
