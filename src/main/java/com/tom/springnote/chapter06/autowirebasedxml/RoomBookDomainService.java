package com.tom.springnote.chapter06.autowirebasedxml;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName RoomBookDomainService.java
 * @Description TODO
 * @createTime 2024年08月16日 06:38:00
 */
public class RoomBookDomainService {

    private IRoomBookSupport roomBookSupport;

    public void book(String roomId, String customer) {
        roomBookSupport.saveRoomBookInf(roomId, customer);
    }

    public void setRoomBookSupport(IRoomBookSupport roomBookSupport) {
        this.roomBookSupport = roomBookSupport;
    }
}
