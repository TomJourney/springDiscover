package com.tom.springnote.chapter11.security;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StringUtils;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName SecurityCheckAspect.java
 * @Description TODO
 * @createTime 2024年08月24日 07:53:00
 */
@Aspect
public class SecurityCheckAspect {

    @Around("execution(* *(..)) && args(userId)")
    public Object checkSecurity(ProceedingJoinPoint joinPoint, String userId) throws Throwable {
        System.out.println("[@Around] checkSecurity() 被调用");
        if (!StringUtils.hasText(userId)) {
            throw new RuntimeException("安全检查不通过： userId为空");
        }
        return joinPoint.proceed();
    }
}
