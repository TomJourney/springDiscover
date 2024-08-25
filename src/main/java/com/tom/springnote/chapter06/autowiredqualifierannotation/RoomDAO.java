package com.tom.springnote.chapter06.autowiredqualifierannotation;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName RootBookDAO.java
 * @Description TODO
 * @createTime 2024年08月16日 06:33:00
 */
public class RoomDAO {

    public void insertRoomBook(String roomId, String customer) {
        System.out.printf("RoomDAO#insertRoomBook(): 插入订房信息成功：roomId=[%s], customer=[%s]\n", roomId, customer);
    }
}
