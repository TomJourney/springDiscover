package com.tom.springnote.chapter20.programtx;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName BusiTransactionTemplate.java
 * @Description TODO
 * @createTime 2024年08月30日 19:56:00
 */
public class BusiTransactionTemplateMain {
    public static void main(String[] args) {
        BusiTransactionTemplate busiTransactionTemplate = new BusiTransactionTemplate();
        busiTransactionTemplate.update(500003L, "张三03B");
    }
}
