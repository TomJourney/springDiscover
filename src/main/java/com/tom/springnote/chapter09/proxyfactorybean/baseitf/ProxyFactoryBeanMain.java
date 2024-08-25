package com.tom.springnote.chapter09.proxyfactorybean.baseitf;

import org.springframework.aop.framework.ProxyFactoryBean;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName ProxyFactoryBeanMain.java
 * @Description TODO
 * @createTime 2024年08月22日 12:59:00
 */
public class ProxyFactoryBeanMain {
    public static void main(String[] args) {
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        Object object = proxyFactoryBean.getObject();
    }
}
