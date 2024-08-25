package com.tom.springnote.chapter09.perclassadvice;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.core.io.Resource;

import java.lang.reflect.Method;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName BeforeAdviceImpl.java
 * @Description TODO
 * @createTime 2024年08月18日 11:40:00
 */
public class BeforeAdviceImpl implements MethodBeforeAdvice {

    private Resource resource;

    public BeforeAdviceImpl(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        if (!resource.exists()) {
            System.out.println("新建资源");
            return ;
        }
        System.out.println("资源已存在，无需二次新建");
    }
}
