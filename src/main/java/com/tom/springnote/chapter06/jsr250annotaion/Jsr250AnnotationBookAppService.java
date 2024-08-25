package com.tom.springnote.chapter06.jsr250annotaion;

import com.tom.springnote.chapter06.autowiredqualifierannotation.AutowireQualifierBookDomainService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName HouseBookAppService.java
 * @Description TODO
 * @createTime 2024年08月16日 06:30:00
 */
public class Jsr250AnnotationBookAppService {

    @Resource(name = "bookDomainService2")
    private AutowireQualifierBookDomainService annotationBookDomainService;

    public Jsr250AnnotationBookAppService() {
        System.out.println("Jsr250AnnotationBookAppService 构造器");
    }

    public void book(String roomId, String customer) {
        annotationBookDomainService.book(roomId, customer);
    }

    @PostConstruct
    public void afterInstance() {
        System.out.println("@PostConstruct注解标注的方法，实例化之后执行");
    }

    @PreDestroy
    public void destory() {
        System.out.println("@PreDestroy注解标注的方法，bean销毁前执行");
    }
}
