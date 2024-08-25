package com.tom.springnote.chapter04.t040202xmlfile;

import com.tom.springnote.chapter04.t0401.NewsProvider;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author TomBrother
 * @version 1.0.0
 * @ClassName LoadBeanFactoryByXmlFileMain.java
 * @Description xml配置格式的加载
 * @createTime 2024年08月01日
 */
public class LoadBeanFactoryByXmlFileMain {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
        BeanFactory container = bindViaXmlFile(beanRegistry);
        NewsProvider baiduNewsProvider = container.getBean("baiduNewsProvider", NewsProvider.class);
        baiduNewsProvider.getAndPersistNews();
    }
    
    public static BeanFactory bindViaXmlFile(BeanDefinitionRegistry beanDefinitionRegistry) {
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanDefinitionRegistry);
        reader.loadBeanDefinitions("classpath:beans0401.xml");
        return (BeanFactory) beanDefinitionRegistry;
    }
}
