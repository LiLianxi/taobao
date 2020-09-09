package com.taobao.order.common.utils;

import com.taobao.order.common.enums.ExceptionEnum;
import com.taobao.order.common.exceptions.HotelException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Lawrence Li
 * @date 2020/9/9 3:52 PM
 */
public class SimpleDateFormatUtil {
    //    private static final ThreadLocal<DateFormat> DATETIME_FORMAT = new ThreadLocal<DateFormat>(){
//        @Override
//        protected DateFormat initialValue() {
//            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        }
//    };

    private static final ThreadLocal<DateFormat> DATE_FORMAT = new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

//    private static final ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<>();
//
//    public static SimpleDateFormat getSimpleDateFormat(String pattern){
//        SimpleDateFormat dateFormat = threadLocal.get();
//        if (dateFormat == null){
//            return new SimpleDateFormat(pattern);
//        }
//        return dateFormat;
//    }


    public static Date parseString(String dateStr, String pattern) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.parse(dateStr);
    }

    public static String getDateStr(Date date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    public static void checkDateString(String date, String pattern){
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            Date d = format.parse(date);
        } catch (ParseException e) {
            throw new HotelException(ExceptionEnum.DATE_FORMAT_INVALID);
        }
    }


}
