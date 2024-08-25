package com.tom.springnote.chapter09.aopbasic;

import com.tom.springnote.chapter08proxypattern.IEmailSender;
import org.springframework.aop.ClassFilter;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName ClassFilterImpl.java
 * @Description TODO
 * @createTime 2024年08月18日 07:21:00
 */
public class ClassFilterImpl implements ClassFilter {
    @Override
    public boolean matches(Class<?> clazz) {
        return IEmailSender.class.equals(clazz);
    }
}
