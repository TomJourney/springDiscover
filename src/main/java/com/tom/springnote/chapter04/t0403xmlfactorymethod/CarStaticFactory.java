package com.tom.springnote.chapter04.t0403xmlfactorymethod;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName CarStatciFactory.java
 * @Description 汽车静态工厂
 * @createTime 2024年08月15日 07:15:00
 */
public class CarStaticFactory {
    private static final AtomicInteger INCREMENTOR = new AtomicInteger(0);

    public static ICar getInstance() {
        return new ElectricCar("特斯拉汽车" + INCREMENTOR.getAndIncrement());
    }
}
