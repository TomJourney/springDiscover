package com.tom.springnote.chapter06.autowiredqualifierannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName RoomBookSupportImpl.java
 * @Description TODO
 * @createTime 2024年08月16日 06:32:00
 */
public class HiltonRoomBookSupportImpl implements IAutowireQualifierBookSupport {
    private RoomDAO bookDAO;
    private HotelDAO hotelDAO;

    @Override
    public void saveRoomBookInf(String roomId, String customer) {
        System.out.println("希尔顿酒店预订助手");
        if (!hotelDAO.IfAuthLegal(customer)) {
            System.out.println("权限校验失败");
            return;
        }
        System.out.println("权限校验成功");
        bookDAO.insertRoomBook(roomId, customer);
    }

    @Autowired
    public void setBookDAO(@Qualifier("roomDAO") RoomDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Autowired
    public void injectHotelDAO(@Qualifier("hotelDAO") HotelDAO hotelDAO) {
        this.hotelDAO = hotelDAO;
    }
}
