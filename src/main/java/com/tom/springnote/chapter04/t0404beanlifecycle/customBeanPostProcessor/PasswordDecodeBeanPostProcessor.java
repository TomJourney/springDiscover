package com.tom.springnote.chapter04.t0404beanlifecycle.customBeanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName PasswordDecodePostProcessor.java
 * @Description 密码解密bean后置处理器
 * @createTime 2024年08月04日 21:09:00
 */
public class PasswordDecodeBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof PasswordDecodable) {
            System.out.println("PasswordDecodable对象的BeanPostProcessor 前置处理");
            PasswordDecodable passwordDecodable = (PasswordDecodable) bean;
            // 密文密码解密后，替换为明文
            passwordDecodable.setDecodedPassword(decode(passwordDecodable.getPassword()));
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    private String decode(String cipherText) {
        System.out.println("PasswordDecodeBeanPostProcessor 执行解密逻辑");
        // 解密逻辑
        return "解密后的" + cipherText;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof PasswordDecodable) {
            System.out.println("PasswordDecodable对象的BeanPostProcessor 后置处理");
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
