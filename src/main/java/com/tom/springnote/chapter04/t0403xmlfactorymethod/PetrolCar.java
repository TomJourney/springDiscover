package com.tom.springnote.chapter04.t0403xmlfactorymethod;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName PetrolCar.java
 * @Description TODO
 * @createTime 2024年08月15日 07:14:00
 */
public class PetrolCar extends ICar {

    public PetrolCar(String name) {
        super(name);
    }

    @Override
    public void drive() {
        System.out.println("name=" + getName() + ", 汽油驱动，人工驾驶");
    }
}
