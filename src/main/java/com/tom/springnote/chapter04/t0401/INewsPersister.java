package com.tom.springnote.chapter04.t0401;

/**
 * @author TomBrother
 * @version 1.0.0
 * @ClassName IFXNewsPersister.java
 * @Description TODO
 * @createTime 2024年08月02日
 */
public interface INewsPersister {
    default void persistNews(NewsDto newsDto){}

    default void persistNews(){}
}
