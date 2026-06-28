package com.tom.srccode.deep.analysis.chapter0501.propertyeditor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

import java.util.Date;

/**
 * @author tom
 * @version 1.0.0
 * @Description TODO
 * @createTime 2026年06月28日 15:04:00
 */
@Slf4j
public class MyDatePropertyEditorRegistrar implements PropertyEditorRegistrar {

    public MyDatePropertyEditorRegistrar() {
        log.info("MyDatePropertyEditorRegistrar-构造器");
    }

    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        registry.registerCustomEditor(Date.class, new MyDatePropertyEditor());
    }
}
