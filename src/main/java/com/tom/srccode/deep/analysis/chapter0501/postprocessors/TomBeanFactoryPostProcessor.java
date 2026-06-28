package com.tom.srccode.deep.analysis.chapter0501.postprocessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.StringValueResolver;

/**
 * @author tom
 * @version 1.0.0
 * @Description TODO
 * @createTime 2026年06月28日 15:27:00
 */
public class TomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanDefinitionName);
            StringValueResolver stringValueResolver = new StringValueResolver() {
                @Override
                public String resolveStringValue(String strVal) {
                    return strVal.startsWith("tom") ? "******" : strVal;
                }
            };

            BeanDefinitionVisitor beanDefinitionVisitor = new BeanDefinitionVisitor(stringValueResolver);
            beanDefinitionVisitor.visitBeanDefinition(beanDefinition);
        }
    }
}
