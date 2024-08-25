package com.tom.springnote.chapter04.t0404beanlifecycle.initmethod;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName CacheService.java
 * @Description TODO
 * @createTime 2024年08月04日 21:58:00
 */
public class CacheService {

    public Map<String, Object> loadCache() {
        Map<String, Object> cache = new HashMap<>(3);
        cache.put("TODO", "待办");
        cache.put("DOIN", "进行中");
        cache.put("DONE", "已完成");
        return cache;
    }
}
