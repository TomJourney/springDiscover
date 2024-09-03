package com.tom.springnote.chapter20.declaretx.beannameautoproxycreator;

import com.tom.springnote.chapter20.declaretx.service.IBankCardService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName DeclareTxBasedBeanNameAutoProxyCreatorMain.java
 * @Description TODO
 * @createTime 2024年09月01日 20:00:00
 */
public class DeclareTxBasedBeanNameAutoProxyCreatorMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext container =
                new ClassPathXmlApplicationContext("chapter20/factorybean/DeclareTxBasedBeanNameAutoProxyCreator.xml");
        IBankCardService bankCardServiceProxy = container.getBean("bankCardServiceImpl", IBankCardService.class);
        // 查询
        System.out.println(bankCardServiceProxy.queryById(1001L));
    }
}
