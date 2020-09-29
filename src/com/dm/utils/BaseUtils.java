package com.dm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

/**
 * 
 * @author 章学魁
 *
 */
public class BaseUtils {
	/**
	 * 获取当前时间
	 * 
	 * @return
	 */
	public String getTime() {
		Date date = new Date();
		String str = "yyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(str);
		String time = sdf.format(date);
		return time;
	}

}
