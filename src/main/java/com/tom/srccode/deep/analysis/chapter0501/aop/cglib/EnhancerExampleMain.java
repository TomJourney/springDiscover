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
public class EnhancerExampleMain {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(EnhancerExample.class);
        enhancer.setCallback(new MethodInterceptorImpl());

        // 获取代理对象
        EnhancerExample enhancerExample = (EnhancerExample)enhancer.create();
        enhancerExample.test();
        log.info("enhancerExample = {}", enhancerExample);
    }

    private static class MethodInterceptorImpl implements MethodInterceptor {
        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            log.info("before invoke , {}", method);
            Object result = proxy.invokeSuper(obj, args);
            log.info("after invoke , {}", method);
            return result;
        }
    }
}
