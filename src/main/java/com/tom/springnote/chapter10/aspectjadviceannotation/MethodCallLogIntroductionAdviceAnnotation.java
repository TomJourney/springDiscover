package com.tom.springnote.chapter10.aspectjadviceannotation;

import com.tom.springnote.chapter10.introductionadviceannotation.AccessLogImpl;
import com.tom.springnote.chapter10.introductionadviceannotation.IAccessLog;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName CallTaskBeforeAnnotation.java
 * @Description TODO
 * @createTime 2024年08月23日 11:39:00
 */
@Aspect
public class MethodCallLogIntroductionAdviceAnnotation {

    @DeclareParents(value="com.tom.springnote.chapter10.target.MessageDAO", defaultImpl = AccessLogImpl.class)
    public IAccessLog accessLog;
}
