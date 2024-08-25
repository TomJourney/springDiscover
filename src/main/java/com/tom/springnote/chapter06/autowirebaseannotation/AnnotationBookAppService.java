package com.tom.springnote.chapter06.autowirebaseannotation;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName HouseBookAppService.java
 * @Description TODO
 * @createTime 2024年08月16日 06:30:00
 */
public class AnnotationBookAppService {

    private AnnotationBookDomainService annotationBookDomainService;

    @Autowired
    public AnnotationBookAppService(AnnotationBookDomainService bookDomainService) {
        this.annotationBookDomainService = bookDomainService;
    }

    public void book(String roomId, String customer) {
        annotationBookDomainService.book(roomId, customer);
    }
}
