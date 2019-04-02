package com.neuedu;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestTimeDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//建立一个时间对象
		Date date = new Date(System.currentTimeMillis());//构造方法中可以无参；也可以时时间戳
		System.out.println(date);
		
		
		//对获取的时间进行格式化
		SimpleDateFormat format = new SimpleDateFormat();
		String _date = format.format(date);
		
		//输入时间
		System.out.println(_date);
		
		//System.out.println(System.currentTimeMillis());//时间戳
		
	}


}
