package com.tom.springnote.chapter04.t0403xmlfactorymethod;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName ElectricCar.java
 * @Description TODO
 * @createTime 2024年08月15日 07:14:00
 */
public class ElectricCar extends ICar {
    public ElectricCar(String name) {
        super(name);
    }
    @Override
    public void drive() {
        System.out.println("name=" + getName() + ", 电池驱动， 自动驾驶");
    }
}
