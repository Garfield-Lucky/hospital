package org.wu.work.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	public static final String BASE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String SHORT_FORMAT = "yyyy-MM-dd";
	public static final String CHINESE_FORMAT = "yyyy年MM月dd日HH时mm分ss�?";
	public static final String CHINESE_FORMAT_NOSECOND = "yyyy年MM月dd日HH时mm�?";
	public static final String SHORT_C_FORMAT = "yyyy年MM月dd�?";
	public static final String EN_FORMAT_A = "yyyyMMddHHmmss";
	public static final String EN_FORMAT_B = "yyyy/MM/dd HH:mm:ss";
	public static final String EN_FORMAT_C = "yyyyMMddHHmmss.SSS";
	public static final String END_DAY_FOMAT_A = "yyyy/MM/dd 23:59:59";
	public static final String END_DAY_FOMAT_B = "yyyy-MM-dd 23:59:59";
	public static final String SHORT_EN_FORMAT = "yyyyMMdd";
	public static final String MINUTE_FORMAT = "yyyyMMddHHmm";
	public static final String CN_SHORT_FORMAT = "MM月dd�?";
	public static final String CN_CUT_FORMAT = "MM月dd�? HH:mm";
	public static final String CN_NOSECOND_FORMAT = "yyyy年MM月dd�? HH:mm";
	public static final String EN_NOSECOND_FORMAT = "yyyy-MM-dd HH:mm";
	
    public final static int ERA = 0;
    public final static int YEAR = 1;
    public final static int MONTH = 2;
    public final static int WEEK_OF_YEAR = 3;
    public final static int WEEK_OF_MONTH = 4;
    public final static int DATE = 5;
    public final static int DAY_OF_MONTH = 5;
    public final static int DAY_OF_YEAR = 6;
    public final static int DAY_OF_WEEK = 7;
    public final static int DAY_OF_WEEK_IN_MONTH = 8;
    public final static int AM_PM = 9;
    public final static int HOUR = 10;
    public final static int HOUR_OF_DAY = 11;
    public final static int MINUTE = 12;
    public final static int SECOND = 13;
    public final static int MILLISECOND = 14;
	
	public static Date now() {
		return new Date();
	}
	
	public static String formatDate() {
		SimpleDateFormat format = new SimpleDateFormat(BASE_FORMAT);
		return format.format(new Date());
	}
	
	public static String formatDate(String formatter, Date date) {
		SimpleDateFormat format = new SimpleDateFormat(formatter);
		return format.format(date);
	}
	
	public static Date yesterday() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
		return calendar.getTime();
	}
	
	public static Date lastMinute() {
		return lastMinute(new Date());
	}
	
	public static Long oneMinute() {
		return 60000l;
	}
	
	public static Long minutes(int num) {
		return num * oneMinute();
	}
	
	public static Long oneHour() {
		return 60 * oneMinute();
	}
	
	public static Long hours(int num) {
		return num * oneHour();
	}
	
	public static Date lastMinute(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, -1);
		return calendar.getTime();
	}
	
	public static Date addDays(Date date, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, days);
		return calendar.getTime();
	}
	
	public static Date addMonths(Date date, int months) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, months);
		return calendar.getTime();
	}
	public static Date addMinutes(Date date, int minute) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, minute);
		return calendar.getTime();
	}
	public static String formatDate(Date date) {
		SimpleDateFormat format = new SimpleDateFormat(BASE_FORMAT);
		return format.format(date);
	}
	
	public static String formatDateShort(Date date) {
		SimpleDateFormat format = new SimpleDateFormat(SHORT_FORMAT);
		return format.format(date);
	}
	
	public static Date addFileds(Date date, int filed, int val) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(filed, val);
		return calendar.getTime();
	}
	
	public static Date startOfDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(date);
		calendar2.set(Calendar.HOUR_OF_DAY, 0);
		calendar2.set(Calendar.MINUTE, 0);
		calendar2.set(Calendar.SECOND, 0);
		calendar2.set(Calendar.MILLISECOND, 0);
		return calendar2.getTime();
	}
	
	public static Date endOfDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(date);
		calendar2.set(Calendar.HOUR_OF_DAY, 23);
		calendar2.set(Calendar.MINUTE, 59);
		calendar2.set(Calendar.SECOND, 59);
		calendar2.set(Calendar.MILLISECOND, 999);
		return calendar2.getTime();
	}
	
	public static Date startOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(date);
		calendar2.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
		calendar2.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
		calendar2.set(Calendar.DATE, 1);
		return startOfDay(calendar2.getTime());
	}
	
	public static Date endOfMonth(Date date) {
		Date tempDate = startOfMonth(date);
		tempDate = addMonths(tempDate, 1);
		tempDate = addDays(tempDate, -1);
		tempDate = endOfDay(tempDate);
		return tempDate;
	}

	public static Date parse(String dateStr) {
		return parse(dateStr, BASE_FORMAT);
	}
	
	public static Date parse(String dateStr, String formatStr) {
		return parse(dateStr, formatStr, null);
	}
	
	public static Date parse(String dateStr, String formatStr, Date defaultDate) {
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		try {
			return format.parse(dateStr);
		} catch (ParseException e) {
			return defaultDate;
		}
	}
	
	public static Date set(Date srcDate, int field, int value) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(srcDate);
		calendar.set(field, value);
		return calendar.getTime();
	}
	
	public static int get(Date srcDate, int field) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(srcDate);
		return calendar.get(field);
	}
	
}
