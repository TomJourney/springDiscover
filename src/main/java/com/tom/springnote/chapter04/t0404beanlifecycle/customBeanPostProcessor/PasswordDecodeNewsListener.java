package com.tom.springnote.chapter04.t0404beanlifecycle.customBeanPostProcessor;

import com.tom.springnote.chapter04.t0401.INewsListener;
import com.tom.springnote.chapter04.t0401.NewsDto;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName PasswordDecodeNewsListener.java
 * @Description 密码可解密的新闻监听器
 * @createTime 2024年08月04日 21:07:00
 */
public class PasswordDecodeNewsListener implements INewsListener, PasswordDecodable {
    Map<String, NewsDto> newsContainer = new HashMap<>(10);

    private String password;

    public PasswordDecodeNewsListener() {
        newsContainer.put("1", new NewsDto("1", "密码可解密新闻1号"));
        newsContainer.put("2", new NewsDto("2", "密码可解密新闻2号"));
        newsContainer.put("3", new NewsDto("3", "密码可解密新闻3号"));
        System.out.println("PasswordDecodeNewsListener构造器");
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

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setDecodedPassword(String password) {
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
