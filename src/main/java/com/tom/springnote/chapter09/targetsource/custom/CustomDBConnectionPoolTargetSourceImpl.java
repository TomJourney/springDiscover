package com.tom.springnote.chapter09.targetsource.custom;

import org.springframework.aop.TargetSource;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName CustomTargetSourceImpl.java
 * @Description TODO
 * @createTime 2024年08月22日 19:23:00
 */
public class CustomDBConnectionPoolTargetSourceImpl implements TargetSource {

    private List<CustomDBConnection> customDBConnectionList;

    private Semaphore semaphore = new Semaphore(1);

    public CustomDBConnectionPoolTargetSourceImpl(int poolSize) {
        customDBConnectionList = new ArrayList<>(poolSize);
        for (int i = 0; i < poolSize; i++) {
            customDBConnectionList.add(new CustomDBConnection(i));
        }
    }

    @Override
    public Class<?> getTargetClass() {
        return CustomDBConnection.class;
    }

    @Override
    public Object getTarget() throws Exception {
        while (true) {
            for (CustomDBConnection connection : customDBConnectionList) {
                if (connection.isAvailable()) {
                    connection.setAvailable(false);
                    return connection;
                }
            }
            semaphore.acquire();
        }
    }

    @Override
    public boolean isStatic() {
        return false;
    }

    @Override
    public void releaseTarget(Object target) throws Exception {
        // 重置可用状态为true
        ((CustomDBConnection) target).setAvailable(true);
        semaphore.release();
    }
}
