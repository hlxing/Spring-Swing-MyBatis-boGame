package com.hlx.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {

	private static final String TIMESTANDARD = "yyyy/MM/dd";


	//解析Unix时间戳
	public static String parseTimeStamp(Long timeStamp){
		Date date = new Date(timeStamp*1000);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		SimpleDateFormat dateFormat = new SimpleDateFormat(TIMESTANDARD);
		return dateFormat.format(date);
	}


}
