package com.tom.springnote.chapter10.aspectjpointcutannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName CustomJoinpointAnnotation.java
 * @Description TODO
 * @createTime 2024年08月23日 11:17:00
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface CustomJoinpointAnnotation {
}
