package com.tom.springnote.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName BusiDatetimeUtils.java
 * @Description TODO
 * @createTime 2024年08月19日 19:02:00
 */
public class BusiDatetimeUtils {

    private static final DateTimeFormatter YYYYMMDD_HHMMSSS_SSS_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    private static final DateTimeFormatter YYYYMMDD_HHMMSSS_NO_SEPARATOR_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    public static String getNowText() {
        return YYYYMMDD_HHMMSSS_SSS_FORMATTER.format(LocalDateTime.now());
    }


    public static Long getCurYyyyMmDdHhMmSs() {
        return Long.parseLong(YYYYMMDD_HHMMSSS_NO_SEPARATOR_FORMATTER.format(LocalDateTime.now()));
    }

    private BusiDatetimeUtils() {
        // do nothing.
    }
}
