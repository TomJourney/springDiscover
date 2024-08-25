package com.tom.springnote.chapter05.applicationcontext;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName DefaultResourceLoaderMain.java
 * @Description TODO
 * @createTime 2024年08月15日 10:13:00
 */
public class FileSystemResourceLoaderMain {
    public static void main(String[] args) {
        ResourceLoader fileSystemResourceLoader = new FileSystemResourceLoader();
        Resource resource = fileSystemResourceLoader.getResource("D:/studynote/spring_discover/ApplicationContext.txt");
        System.out.println(resource.getClass());
        // class org.springframework.core.io.FileSystemResourceLoader$FileSystemContextResource

        Resource fileURlResource = fileSystemResourceLoader.getResource("file:D:/studynote/spring_discover/ApplicationContext.txt");
        System.out.println(fileURlResource.getClass());
        // class org.springframework.core.io.FileUrlResource
    }
}
