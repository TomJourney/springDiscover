package com.tom.springnote.chapter06.autowirebasedxml;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName RootBookDAO.java
 * @Description TODO
 * @createTime 2024年08月16日 06:33:00
 */
public class RoomBookDAO {

    public void insertRoomBook(String roomId, String customer) {
        System.out.printf("RoomBookDAO: 插入订房信息成功：roomId=[%s], customer=[%s]\n", roomId, customer);
    }
}
