package com.tom.springnote.chapter04.t0401;

/**
 * @author TomBrother
 * @version 1.0.0
 * @ClassName IFXNewsListener.java
 * @Description TODO
 * @createTime 2024年08月02日
 */
public interface INewsListener {
    String[] getAvailableNewsIds();

    NewsDto getNewsByPk(String newsId);

    void postProcessIfNeed(String newsId);

    String getListenerId();
}
