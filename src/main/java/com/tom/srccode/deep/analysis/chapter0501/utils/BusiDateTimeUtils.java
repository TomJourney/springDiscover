package com.tom.srccode.deep.analysis.chapter0501.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author tom
 * @version 1.0.0
 * @Description TODO
 * @createTime 2026年06月28日 15:16:00
 */
public class BusiDateTimeUtils {

    /** 日期时间格式化器 */
    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /** 日期格式化器 */
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private BusiDateTimeUtils() {
        // do nothing.
    }

    /** -------------------- 1. 当前日期时间操作 -------------------- */
    public static String getNowLocalDateTimeStr() {
        return LocalDateTime.now().format(DATETIME_FORMATTER);
    }

    public static String getNowLocalDateStr() {
        return LocalDate.now().format(DATE_FORMATTER);
    }

    /** -------------------- 2. 字符串解析为日期时间对象 -------------------- */
    public static LocalDateTime parseLocalDateTime(String dateTimeStr) {
        return LocalDateTime.parse(dateTimeStr, DATETIME_FORMATTER);
    }

    public static LocalDate parseLocalDate(String dateStr) {
        return LocalDate.parse(dateStr, DATE_FORMATTER);
    }

    /** -------------------- 3. 日期时间对象格式化为字符串 -------------------- */
    public static String format(LocalDateTime localDateTime) {
        return localDateTime.format(DATETIME_FORMATTER);
    }
    public static String format(LocalDate localDate) {
        return localDate.format(DATE_FORMATTER);
    }

    /** -------------------- 4. LocalDateTime 转为其他日期时间类型 -------------------- */
    public static LocalDate toLocalDate(LocalDateTime localDateTime) {
        return localDateTime.toLocalDate();
    }

    public static Instant toInstant(LocalDateTime localDateTime) {
        return localDateTime.toInstant(ZoneOffset.UTC);
    }

    public static Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /** -------------------- 5. LocalDate 转为其他日期时间类型 -------------------- */
    public static LocalDateTime toLocalDateTime(LocalDate localDate) {
        return localDate.atStartOfDay();
    }

    public static Instant toInstant(LocalDate localDate) {
        return localDate.atStartOfDay().toInstant(ZoneOffset.UTC);
    }

    public static Date toDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    /** -------------------- 6. Instant 转为其他日期时间类型 -------------------- */
    public static LocalDateTime toLocalDateTime(Instant instantWithoutZone) {
        return LocalDateTime.ofInstant(instantWithoutZone, ZoneOffset.UTC);
    }

    public static LocalDate toLocalDate(Instant instantWithoutZone) {
        return toLocalDateTime(instantWithoutZone).toLocalDate();
    }

    public static Date toDate(Instant instantWithoutZone) {
        return toDate(toLocalDateTime(instantWithoutZone));
    }

}
