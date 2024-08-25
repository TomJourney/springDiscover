package com.tom.springnote.chapter09.advisor.introduction;

import com.tom.springnote.chapter09.ITrainingSchoolTeacher;
import com.tom.springnote.chapter09.perinstanceadvice.PublicSchoolTeacher;
import com.tom.springnote.chapter09.perinstanceadvice.TrainingSchoolTeacherImpl;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultIntroductionAdvisor;
import org.springframework.aop.support.DelegatePerTargetObjectIntroductionInterceptor;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName IntroductionAdvisorMain.java
 * @Description TODO
 * @createTime 2024年08月21日 20:35:00
 */
public class DefaultIntroductionAdvisorMain {
    public static void main(String[] args) {
        // 新建目标对象
        PublicSchoolTeacher target = new PublicSchoolTeacher();
        // 新建织入器
        ProxyFactory weaver = new ProxyFactory(target);
        // 使用CGLIB实现动态代理，因为目标对象没有实现接口（而不是JDK动态代理）
        weaver.setProxyTargetClass(true);
        // 新建动态引入型通知
        DelegatePerTargetObjectIntroductionInterceptor delegateIntroductionAdvice =
                new DelegatePerTargetObjectIntroductionInterceptor(TrainingSchoolTeacherImpl.class, ITrainingSchoolTeacher.class);

        // 新建引用型切面，封装引用型通知
        DefaultIntroductionAdvisor defaultIntroductionAdvisor = new DefaultIntroductionAdvisor(delegateIntroductionAdvice);
        // 织入器装配引入型切面
        weaver.addAdvisor(defaultIntroductionAdvisor);

        // 织入器织入切面并获取代理对象
        Object proxy = weaver.getProxy();
        ((PublicSchoolTeacher) proxy).teach(); // 代理对象转为目标对象并调用已有方法
        ((ITrainingSchoolTeacher) proxy).trainAfterSchool(); // 代理对象转为横切逻辑接口对象并调用新方法
    }
}
