package com.tom.springnote.chapter09.proxyfactorybean.baseclassintroduction;

import com.tom.springnote.common.aop.BusiMessage;
import com.tom.springnote.common.aop.ICallTask;
import com.tom.springnote.common.aop.IIntroduceMethodAccessLog;
import com.tom.springnote.common.aop.IIntroduceMethodInvokeCounter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName ProxyFactoryBeanMain.java
 * @Description TODO
 * @createTime 2024年08月20日 09:53:00
 */
public class BaseClassIntroductionProxyFactoryBeanMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext container =
                new ClassPathXmlApplicationContext("chapter09/beans09proxyfactorybeanbasedclassintroduction.xml");
        Object proxyBean = container.getBean("introducedRobotCallTaskImplProxy");
        Object proxyBean2 = container.getBean("introducedRobotCallTaskImplProxy");

        // 转为 ICallTask 类型
        ICallTask callTask = (ICallTask) proxyBean;
        callTask.call(BusiMessage.build("任务编号01", "您有待办任务需要处理"));
        // 转为引入型接口1的对象
        IIntroduceMethodInvokeCounter introducedMethodInvokeCounter = (IIntroduceMethodInvokeCounter) proxyBean;
        introducedMethodInvokeCounter.getCounter();
        introducedMethodInvokeCounter.getCounter();
        // 第2个bean调用
        ((IIntroduceMethodInvokeCounter) proxyBean2).getCounter();
        ((IIntroduceMethodInvokeCounter) proxyBean2).getCounter();

        // 转为引入型接口2的对象
        IIntroduceMethodAccessLog introduceMethodAccessLog = (IIntroduceMethodAccessLog) proxyBean;
        introduceMethodAccessLog.sendAccessLog();
    }
}
