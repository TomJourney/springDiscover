package com.tom.springnote.chapter11.target;

import java.io.File;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName BusiFileReader.java
 * @Description TODO
 * @createTime 2024年08月24日 07:26:00
 */
public class BusiFileReader {

    public String readFileName(String path) {
        File file = new File(path);
        if (file.exists()) {
            return file.getName();
        } else {
            throw new RuntimeException("文件不存在");
        }
    }
}
