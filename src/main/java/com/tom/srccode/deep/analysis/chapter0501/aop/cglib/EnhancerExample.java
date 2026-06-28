package com.tom.srccode.deep.analysis.chapter0501.aop.cglib;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author tom
 * @version 1.0.0
 * @Description TODO
 * @createTime 2026年06月28日 17:25:00
 */
@Slf4j
public class EnhancerExample {

    public void test() {
      log.info("EnhancerExample test().");
    }
}
