package com.tom.springnote.chapter05.chapter0504;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName RoomBookSupportImpl.java
 * @Description TODO
 * @createTime 2024年08月16日 06:32:00
 */
public class RoomBookSupportImpl implements IRoomBookSupport {

    private RoomBookDAO roomBookDAO;

    @Override
    public void saveRoomBookInf(String roomId, String customer) {
        roomBookDAO.insertRoomBook(roomId, customer);
    }

    public void setRoomBookDAO(RoomBookDAO roomBookDAO) {
        this.roomBookDAO = roomBookDAO;
    }
}
