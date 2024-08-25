package com.tom.springnote.chapter09.perinstanceadvice;

import com.tom.springnote.chapter09.ITrainingSchoolTeacher;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName TrainingTeacherImpl.java
 * @Description TODO
 * @createTime 2024年08月21日 16:19:00
 */
public class TrainingSchoolTeacherIntroducationInterceptorImpl extends DelegatingIntroductionInterceptor implements ITrainingSchoolTeacher {

    @Override
    public void trainAfterSchool() {
        System.out.println("TrainingSchoolTeacherImpl#trainAfterSchool： 兼职课后培训老师，辅导课后作业");
    }
}
