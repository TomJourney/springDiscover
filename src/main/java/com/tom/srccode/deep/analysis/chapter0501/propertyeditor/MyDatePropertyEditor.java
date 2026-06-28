package com.tom.srccode.deep.analysis.chapter0501.propertyeditor;

import com.tom.srccode.deep.analysis.chapter0501.utils.BusiDateTimeUtils;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author tom
 * @version 1.0.0
 * @Description TODO
 * @createTime 2026年06月28日 14:56:00
 */
@Slf4j
public class MyDatePropertyEditor extends PropertyEditorSupport {

    private final DateTimeFormatter yyyyMmDdFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public void setAsText(String dateStr) {
        log.info("dateStr = {}", dateStr);
        try {
            this.setValue(BusiDateTimeUtils.toDate(LocalDate.parse(dateStr, yyyyMmDdFormatter)));
        } catch (Exception e) {
            log.error("日期转换异常， dateStr={}", dateStr, e);
            throw new RuntimeException("日期转换异常");
        }
    }
}
