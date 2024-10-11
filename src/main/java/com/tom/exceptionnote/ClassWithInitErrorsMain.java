package com.tom.exceptionnote;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName ClassFailWhenInit.java
 * @Description TODO
 * @createTime 2024年09月13日 22:42:00
 */
public class ClassWithInitErrorsMain {

    public static void main(String[] args) {
        new ClassInitError().f1();
    }
}
