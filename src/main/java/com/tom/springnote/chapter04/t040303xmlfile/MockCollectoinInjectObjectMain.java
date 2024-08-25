package com.tom.springnote.chapter04.t040303xmlfile;

import com.tom.springnote.chapter04.t0401.INewsListener;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class MockCollectoinInjectObjectMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext container =
                new ClassPathXmlApplicationContext("classpath:beans0403collection.xml");
        MockCollectoinInjectObject mockCollectoinInjectObject = container.getBean(MockCollectoinInjectObject.class);
        System.out.println(mockCollectoinInjectObject.getListenerList().size());
        System.out.println(mockCollectoinInjectObject.getListenerSet().size());
        System.out.println(mockCollectoinInjectObject.getListenerMap().keySet());
        System.out.println(mockCollectoinInjectObject.getListenerProps().keySet());
    }
}
