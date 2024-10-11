package com.tom.exceptionnote;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName ClassFailWhenInit.java
 * @Description TODO
 * @createTime 2024年09月13日 22:42:00
 */
public class ClassInitError {
    static int data = 1 / 1;

    public void f1() {
        System.out.println("ClassWithInitErrors.f1() executes successfully");
    }
}
