package com.tom.springnote.chapter05.chapter0503.springevent;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.Date;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName BusiDatetimeUtils.java
 * @Description TODO
 * @createTime 2024年08月15日 16:02:00
 */
public class BusiDatetimeUtils {

    private static final DateTimeFormatter YYYY_MM_DD_HH_MM_SS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String timestampToDatetime(long timestamp) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault());
        return YYYY_MM_DD_HH_MM_SS.format(localDateTime);
    }

    private BusiDatetimeUtils() {
        // do nothing.
    }
}
