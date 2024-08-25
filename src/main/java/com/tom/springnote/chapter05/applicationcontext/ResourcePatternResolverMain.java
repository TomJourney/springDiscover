package com.tom.springnote.chapter05.applicationcontext;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName ResourcePatternResolverMain.java
 * @Description TODO
 * @createTime 2024年08月15日 10:27:00
 */
public class ResourcePatternResolverMain {
    public static void main(String[] args) throws IOException {
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        // getResources() 批量加载多个文件或读取多个文件
        Resource[] resources = resourcePatternResolver.getResources("file:D:/studynote/spring_discover/ApplicationContext*.txt");
        for (Resource resource : resources) {
            System.out.println(resource.getFile().getName() + ", class=" + resource.getClass());
        }
        // ApplicationContext.txt, class=class org.springframework.core.io.FileSystemResource
        // ApplicationContext2.txt, class=class org.springframework.core.io.FileSystemResource
    }
}
