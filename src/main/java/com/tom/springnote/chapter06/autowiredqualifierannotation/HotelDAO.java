package com.tom.springnote.chapter06.autowiredqualifierannotation;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName HotelRoomHttpClient.java
 * @Description TODO
 * @createTime 2024年08月16日 10:07:00
 */
public class HotelDAO {

    public boolean IfAuthLegal(String customer) {
        System.out.printf("HotelDAO#IfAuthLegal()： [%s]权限校验合法\n", customer);
        return true;
    }
}
