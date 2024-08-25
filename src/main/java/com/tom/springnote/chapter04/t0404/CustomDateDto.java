package com.tom.springnote.chapter04.t0404;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName CustomDateBean.java
 * @Description 自定义date dto
 * @createTime 2024年08月04日 07:45:00
 */
public class CustomDateDto {
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "CustomDateDto{" +
                "date=" + date +
                '}';
    }
}
