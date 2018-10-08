package org.wu.work.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {

	public static final String BASE_FORMAT_A = "yyyy-MM-dd hh:mm:ss";
	public static final String BASE_FORMAT_B = "yyyy/MM/dd hh:mm:ss";
	public static final String SHORT_FORMAT_A = "yyyy-MM-dd";
	public static final String SHORT_FORMAT_B = "yyyy/MM/dd";
	public static final String YMONTH_FORMAT_A = "yyyy-MM";
	public static final String YMONTH_FORMAT_B = "yyyy/MM";
	public static final String YEAR_FORMAT = "yyyy";
	public static final String TIME_FORMAT = "yyyyMMddhhmmss";
	
	/**
	 * 
	 * @param day(0:Ϊ     ʱ  ,    Ϊ  ǰʱ    ǰ  ʱ 䣬       Ժ  ʱ 䡣û  һ    һ  )
	 * @return String   ͵ ʱ   ʽ
	 * 
	 */
	
	public static String OtherDayFormat(int day,String format){
		Date date = new Date(); 
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, day);
		date = calendar.getTime();	
		String time = (new SimpleDateFormat(format)).format(date);
		return time;
	}
	
	public static String OtherYearFormat(int year,String format){
		int day = year*365;
		String time = TimeUtil.OtherDayFormat(day, format);
		return time;
	}
	
	public static Long DateMis(String date){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try
		{
		    Date d1 = df.parse(OtherDayFormat(0,TimeUtil.SHORT_FORMAT_A));
		    Date d2 = df.parse(date);
		    long diff = d1.getTime() - d2.getTime();
		    long days = diff / (1000 * 60 * 60 * 24);
		    return days;
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	
	public static String formatDate(String date) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟  
		java.util.Date date1;
		try {
			date1 = sdf.parse(date);
			SimpleDateFormat format = new SimpleDateFormat(SHORT_FORMAT_A);
			return format.format(date1);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static Long DateDay(String starTime,String endTime){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try
		{
		    Date stime = df.parse(starTime);
		    Date etime = df.parse(endTime);
		    long diff = etime.getTime() - stime.getTime();
		    long days = diff / (1000 * 60 * 60 * 24);
		    return days;
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public static void main(String[] args) {
//		String date = OtherDayFormat(TimeUtil.NEXT_YEAR,TimeUtil.BASE_FORMAT_A);
//		String date = OtherYearFormat(-1,TimeUtil.BASE_FORMAT_A);
		Long date = DateMis("2017-02-15");
		System.out.println(date);
	}
	
	
	
}
