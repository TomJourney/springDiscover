package com.tom.springnote.chapter06.autowiredqualifierannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName HouseBookAppService.java
 * @Description TODO
 * @createTime 2024年08月16日 06:30:00
 */
public class ResourceBookAppService {

    private AutowireQualifierBookDomainService annotationBookDomainService;

    @Autowired
    public ResourceBookAppService(@Qualifier("bookDomainService2") AutowireQualifierBookDomainService bookDomainService) {
        this.annotationBookDomainService = bookDomainService;
    }

    public void book(String roomId, String customer) {
        annotationBookDomainService.book(roomId, customer);
    }
}
