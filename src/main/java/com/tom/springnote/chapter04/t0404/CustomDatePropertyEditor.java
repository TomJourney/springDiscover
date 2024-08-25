package com.tom.springnote.chapter04.t0404;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName CustomDatePropertyEditor.java
 * @Description 自定义日期属性编辑器
 * @createTime 2024年08月04日 07:39:00
 */
public class CustomDatePropertyEditor extends PropertyEditorSupport {
    private String datePattern;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            setValue(new SimpleDateFormat(getDatePattern()).parse(text));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public String getDatePattern() {
        return datePattern;
    }

    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }
}
