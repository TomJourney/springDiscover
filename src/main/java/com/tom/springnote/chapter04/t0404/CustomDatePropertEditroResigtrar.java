package com.tom.springnote.chapter04.t0404;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

import java.beans.PropertyEditor;
import java.util.Date;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName CustomDatePropertEditroResigtrar.java
 * @Description 自定义日期属性编辑器注册器
 * @createTime 2024年08月04日 07:49:00
 */
public class CustomDatePropertEditroResigtrar implements PropertyEditorRegistrar {
    private PropertyEditor customDatePropertyEditor;
    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        registry.registerCustomEditor(Date.class, getCustomDatePropertyEditor());
    }

    public PropertyEditor getCustomDatePropertyEditor() {
        return customDatePropertyEditor;
    }

    public void setCustomDatePropertyEditor(PropertyEditor customDatePropertyEditor) {
        this.customDatePropertyEditor = customDatePropertyEditor;
    }
}
