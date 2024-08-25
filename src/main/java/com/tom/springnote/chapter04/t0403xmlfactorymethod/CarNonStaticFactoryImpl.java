package com.tom.springnote.chapter04.t0403xmlfactorymethod;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName CarNonStaticFactory.java
 * @Description TODO
 * @createTime 2024年08月15日 07:36:00
 */
public class CarNonStaticFactoryImpl implements ICarFactory {

    private static final AtomicInteger INCREMENTOR = new AtomicInteger(0);

    @Override
    public ICar getInstance() {
        return new PetrolCar("奔驰汽车" + INCREMENTOR.getAndIncrement());
    }
}
