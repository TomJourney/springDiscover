package com.tom.springnote.chapter09.targetsource.custom;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName CustomDBConnection.java
 * @Description TODO
 * @createTime 2024年08月22日 19:35:00
 */
public class CustomDBConnection {
    private long connectId;
    private boolean available;

    public CustomDBConnection(long connectId) {
        this.connectId = connectId;
        this.available = true;
    }

    public long getConnectId() {
        return connectId;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void printConnectId() {
        System.out.println("connectId=" + connectId);
    }
}
