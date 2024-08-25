package com.tom.springnote.chapter06.autowirebaseannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName RoomBookDomainService.java
 * @Description TODO
 * @createTime 2024年08月16日 06:38:00
 */
public class AnnotationBookDomainService {

    @Autowired
    private IAnnotationBookSupport bookSupport;

    public void book(String roomId, String customer) {
        bookSupport.saveRoomBookInf(roomId, customer);
    }
}
