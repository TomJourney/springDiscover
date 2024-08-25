package com.tom.springnote.chapter09.perinstanceadvice.staticintroductionadvice;

import com.tom.springnote.chapter09.ITrainingSchoolTeacher;
import com.tom.springnote.chapter09.perinstanceadvice.PublicSchoolTeacher;
import com.tom.springnote.chapter09.perinstanceadvice.TrainingSchoolTeacherIntroducationInterceptorImpl;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName IntroductionAdviceMain.java
 * @Description TODO
 * @createTime 2024年08月21日 16:05:00
 */
public class StaticIntroductionAdviceMain {
    public static void main(String[] args) {
        // 新建织入器
        PublicSchoolTeacher target = new PublicSchoolTeacher();
        ProxyFactory weaver = new ProxyFactory(target);
        // 使用CGLIB实现动态代理，因为目标对象没有实现接口（而不是JDK动态代理）
        weaver.setProxyTargetClass(true);

        // 设置横切逻辑（新增逻辑）的接口 ITrainingSchoolTeacher， 新建引入型横切逻辑
        // 引入型横切逻辑继承了 DelegatingIntroductionInterceptor， 实现了接口 ITrainingSchoolTeacher
        weaver.setInterfaces(ITrainingSchoolTeacher.class);
        TrainingSchoolTeacherIntroducationInterceptorImpl advice = new TrainingSchoolTeacherIntroducationInterceptorImpl();
        // 织入器装配引入型横切逻辑
        weaver.addAdvice(advice);

        // 织入器织入并获取代理对象
        Object proxy = weaver.getProxy();
        ((PublicSchoolTeacher) proxy).teach(); // 代理对象转为目标对象并调用已有方法
        ((ITrainingSchoolTeacher) proxy).trainAfterSchool(); // 代理对象转为横切逻辑接口对象并调用新方法
    }
}
