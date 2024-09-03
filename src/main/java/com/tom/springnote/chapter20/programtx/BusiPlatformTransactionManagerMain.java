package com.tom.springnote.chapter20.programtx;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName BusiPlatformTransactionManager.java
 * @Description TODO
 * @createTime 2024年08月30日 17:23:00
 */
public class BusiPlatformTransactionManagerMain {

    public static void main(String[] args) {
        BusiPlatformTransactionManager txManager = new BusiPlatformTransactionManager();
        txManager.update(500003L ,"张三03A");
    }
}
