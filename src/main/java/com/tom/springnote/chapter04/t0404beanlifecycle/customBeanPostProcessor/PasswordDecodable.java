package com.tom.springnote.chapter04.t0404beanlifecycle.customBeanPostProcessor;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName PasswordDecodable.java
 * @Description 可解密的密码接口
 * @createTime 2024年08月04日 21:05:00
 */
public interface PasswordDecodable {
    String getPassword();

    void setDecodedPassword(String password);
}
