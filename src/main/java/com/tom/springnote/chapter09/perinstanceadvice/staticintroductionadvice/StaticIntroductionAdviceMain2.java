package com.tom.springnote.chapter09.perinstanceadvice.staticintroductionadvice;

import com.tom.springnote.chapter09.ITrainingSchoolTeacher;
import com.tom.springnote.chapter09.perinstanceadvice.PublicSchoolTeacher;
import com.tom.springnote.chapter09.perinstanceadvice.TrainingSchoolTeacherImpl;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName IntroductionAdviceMain.java
 * @Description TODO
 * @createTime 2024年08月21日 16:05:00
 */
public class StaticIntroductionAdviceMain2 {
    public static void main(String[] args) {
        // 新建织入器
        PublicSchoolTeacher target = new PublicSchoolTeacher();
        ProxyFactory weaver = new ProxyFactory(target);
        // 使用CGLIB实现动态代理，因为目标对象没有实现接口（而不是JDK动态代理）
        weaver.setProxyTargetClass(true);

        // 设置引入型横切逻辑（新增逻辑）的接口 新建引入型横切逻辑
        // 引入型横切逻辑实现了接口 ITrainingSchoolTeacher，作为DelegatingIntroductionInterceptor构造器参数传入
        weaver.setInterfaces(ITrainingSchoolTeacher.class);
        TrainingSchoolTeacherImpl delegate = new TrainingSchoolTeacherImpl();
        DelegatingIntroductionInterceptor advice = new DelegatingIntroductionInterceptor(delegate);
        //织入器装配引入型横切逻辑
        weaver.addAdvice(advice);

        // 织入器织入并获取代理对象
        Object proxy = weaver.getProxy();
        ((PublicSchoolTeacher) proxy).teach(); // 代理对象转为目标对象并调用已有方法
        ((ITrainingSchoolTeacher) proxy).trainAfterSchool(); // 代理对象转为横切逻辑接口对象并调用新方法
    }
}
