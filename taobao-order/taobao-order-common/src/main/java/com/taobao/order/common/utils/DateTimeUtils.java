package com.taobao.order.common.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @author Lawrence Li
 * @date 2020/9/9 3:39 PM
 */
public class DateTimeUtils {

    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
    public static final DateTimeFormatter YEAR_MONTH_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM");
    public static final DateTimeFormatter SHORT_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyMMdd");
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter SHORT_DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyMMddHHmmss");
    public static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter LONG_DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss SSS");


    public static LocalDate getCurrentLocalDate(){
        return LocalDate.now();
    }

    public static LocalTime getCurrentLocalTime(){
        return LocalTime.now();
    }

    public static LocalDateTime getCurrentLocalDateTime(){
        return LocalDateTime.now();
    }


    /**
     * get currentDate string 'yyyy-MM-dd'
     * @return
     */
    public static String getCurrentDateStr(){
        return LocalDate.now().format(DATE_FORMATTER);
    }

    /**
     * get current time 'HH:mm:ss'
     * @return
     */
    public static String getCurrentTimeStr(){
        return LocalTime.now().format(TIME_FORMATTER);
    }

    /**
     * get current dateTime 'yyyy-MM-dd HH:mm:ss'
     * @return
     */
    public static String getCurrentDateTimeStr(){
        return LocalDateTime.now().format(DATETIME_FORMATTER);
    }

    /**
     * get current datetime start 'yyyy-MM-dd 00:00:00'
     * @return
     */
    public static LocalDateTime getCurrentDateTimeStart(){
        return LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
    }

    /**
     * yyMMddHHmmss
     * @return
     */
    public static String getCurrentShortDateTimeStr() {
        return LocalDateTime.now().format(SHORT_DATETIME_FORMATTER);
    }

    public static String getCurrentDateStr(String pattern) {
        return LocalDate.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String getCurrentDateTimeStr(String pattern) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String getCurrentTimeStr(String pattern) {
        return LocalTime.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDate parseLocalDate(String localDate, String pattern){
        return LocalDate.parse(localDate, DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalTime parseLocalTime(String localTime, String pattern){
        return LocalTime.parse(localTime, DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDateTime parseLocalDateTime(String localDateTime, String pattern){
        return LocalDateTime.parse(localDateTime, DateTimeFormatter.ofPattern(pattern));
    }

    public static String formatLocalDate(LocalDate localDate, String pattern){
        return localDate.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String formatLocalTime(LocalTime localTime, String pattern){
        return localTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String formatCurrentLocalDateTime(String pattern){
        return formatLocalDateTime(getCurrentLocalDateTime(), pattern);
    }


    public static String formatLocalDateTime(LocalDateTime dateTime, String pattern){
        return dateTime.format(DateTimeFormatter.ofPattern(pattern));
    }


    public static long periodDays(LocalDate startDate, LocalDate endDate) {
        return startDate.until(endDate, ChronoUnit.DAYS);
    }


    public static long periodWeeks(LocalDate startDate, LocalDate endDate) {
        return startDate.until(endDate, ChronoUnit.WEEKS);
    }


    public static long periodMonths(LocalDate startDate, LocalDate endDate) {
        return startDate.until(endDate, ChronoUnit.MONTHS);
    }

    /**
     *  years between two LocalDate
     * @param startDate
     * @param endDate
     * @return
     */
    public static long periodYears(LocalDate startDate, LocalDate endDate) {
        return startDate.until(endDate, ChronoUnit.YEARS);
    }

    /**
     * is today or not
     * @param date
     * @return
     */
    public static boolean isToday(LocalDate date) {
        return getCurrentLocalDate().equals(date);
    }

    /**
     * get current milliseconds
     * @param dateTime
     * @return
     */
    public static Long toEpochMilli(LocalDateTime dateTime) {
        return dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * is leap year or not
     * @param localDate
     * @return
     */
    public static boolean isLeapYear(LocalDate localDate){
        return localDate.isLeapYear();
    }

    private DateTimeUtils() {
    }

}
