package com.dingli.pubcom.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ComUtil {

	// 获取当前时间
	public static String getNowTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(new Date());
	}
}
