package com.tom.springnote.chapter04.t0404beanlifecycle.initmethod;

import org.springframework.beans.factory.InitializingBean;

import java.util.Map;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName InitMethodInitializingNewsDto.java
 * @Description 使用 InitMethod 或 InitializingBean 加载缓存
 * @createTime 2024年08月04日 21:52:00
 */
public class InitMethodInitializingCache implements InitializingBean {
    private CacheService cacheService;
    private Map<String, Object> cache;

    public InitMethodInitializingCache(CacheService cacheService) {
        this.cacheService = cacheService;
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet 缓存加载完成");
        cache = cacheService.loadCache();
    }

    public void init() {
        System.out.println("init 缓存加载完成");
        cache = cacheService.loadCache();
    }

    public Map<String, Object> getCache() {
        return cache;
    }
}
