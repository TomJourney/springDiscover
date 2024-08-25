package com.tom.springnote.chapter06.autowirebasedxml;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName HouseBookAppService.java
 * @Description TODO
 * @createTime 2024年08月16日 06:30:00
 */
public class RoomBookAppService {

    private RoomBookDomainService roomBookDomainService;

    public RoomBookAppService(RoomBookDomainService roomBookDomainService) {
        this.roomBookDomainService = roomBookDomainService;
    }

    public void book(String roomId, String customer) {
        roomBookDomainService.book(roomId, customer);
    }
}
