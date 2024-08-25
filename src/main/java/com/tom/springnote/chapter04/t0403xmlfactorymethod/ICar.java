package com.tom.springnote.chapter04.t0403xmlfactorymethod;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName ICar.java
 * @Description TODO
 * @createTime 2024年08月15日 07:12:00
 */
public abstract class ICar {
    private String name = "";

    public ICar() {
    }

    public ICar(String name) {
        this.name = name;
    }

    abstract void drive();

    public String getName() {
        return name;
    }
}
