package com.tom.springnote.chapter11.cache;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName CacheAspect.java
 * @Description TODO
 * @createTime 2024年08月24日 09:44:00
 */
@Aspect
public class CacheAspect {

    private static final ConcurrentHashMap<String, Object> cache = new ConcurrentHashMap<>();

    @Around("args(usreId)")
    public Object userInfoCache(ProceedingJoinPoint joinPoint, String userId) throws Throwable {
        System.out.println("[@Around] userInfoCache()被调用");
        Object value = cache.get(userId);
        if (Objects.isNull(value)) {
            cache.putIfAbsent(userId, joinPoint.proceed());
        }
        return value;
    }
}
