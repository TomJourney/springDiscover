package com.tom.springnote.chapter04.t0403xmlfactorymethod;

import org.springframework.beans.factory.FactoryBean;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName CarFactoryBeanImpl.java
 * @Description TODO
 * @createTime 2024年08月15日 07:50:00
 */
public class CarFactoryBeanImpl implements FactoryBean<ICar> {

    private static final AtomicInteger start = new AtomicInteger(0);

    @Override
    public ICar getObject() throws Exception {
        return new ElectricCar("FactoryBean特斯拉" + start.getAndIncrement());
    }

    @Override
    public Class<?> getObjectType() {
        return ICar.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
