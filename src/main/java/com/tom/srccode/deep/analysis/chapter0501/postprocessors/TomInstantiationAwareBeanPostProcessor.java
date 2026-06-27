package com.tom.srccode.deep.analysis.chapter0501.postprocessors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

/**
 * @author tom
 * @version 1.0.0
 * @Description TODO
 * @createTime 2026年06月27日 11:20:00
 */
@Slf4j
public class TomInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    public TomInstantiationAwareBeanPostProcessor() {
        super();
        log.info("TomInstantiationAwareBeanPostProcessor-构造器被调用");
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        log.info("postProcess BeforeInstantiation() 触发了");
        return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInstantiation(beanClass, beanName);
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        log.info("postProcess AfterInstantiation() 触发了");
        return InstantiationAwareBeanPostProcessor.super.postProcessAfterInstantiation(bean, beanName);
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        log.info("postProcessProperties() 触发了");
        return InstantiationAwareBeanPostProcessor.super.postProcessProperties(pvs, bean, beanName);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("postProcess BeforeInitialization() 触发了");
        return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("postProcess AfterInitialization() 触发了");
        return InstantiationAwareBeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
