package com.tom.springnote.chapter05.applicationcontext;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName DefaultResourceLoaderMain.java
 * @Description TODO
 * @createTime 2024年08月15日 10:13:00
 */
public class DefaultResourceLoaderMain {
    public static void main(String[] args) {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("D:/studynote/spring_discover/ApplicationContext.txt");
        System.out.println(resource.getClass()); // class org.springframework.core.io.DefaultResourceLoader$ClassPathContextResource

        Resource fileUrlResource = resourceLoader.getResource("file:D:/studynote/spring_discover/ApplicationContext.txt");
        System.out.println(fileUrlResource.getClass()); // class org.springframework.core.io.FileUrlResource

        Resource urllResource = resourceLoader.getResource("https://www.baidu.com/");
        System.out.println(urllResource.getClass()); // class org.springframework.core.io.UrlResource
    }
}
