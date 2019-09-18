package smart;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
/*
 * 创建一个类，用于获取实时的时间
 */
public class MyTime {
	private static String date;
	
	public static String getTime()
	{
		Date dt = new Date();
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.MEDIUM,Locale.CHINA);
		date=df.format(dt);
		return date;	
	}
}
