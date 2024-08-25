package com.tom.springnote.chapter04.t0401;

/**
 * @author TomBrother
 * @version 1.0.0
 * @ClassName FXNewsBean.java
 * @Description TODO
 * @createTime 2024年08月02日
 */
public class NewsDto {
    private String newsId;
    private String newsTitle;

    public NewsDto() {
        // do nothing.
    }

    public NewsDto(String newsId, String newsTitle) {
        this.newsId = newsId;
        this.newsTitle = newsTitle;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    @Override
    public String toString() {
        return "NewsDto{" +
                "newsId='" + newsId + '\'' +
                ", newsTitle='" + newsTitle + '\'' +
                '}';
    }
}
