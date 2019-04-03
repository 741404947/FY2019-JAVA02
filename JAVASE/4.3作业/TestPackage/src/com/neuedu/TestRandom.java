package com.neuedu;

import java.util.Random;
import java.util.Scanner;

public class TestRandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestRandom tr = new TestRandom();
		String num = tr.testRandom(4);
		System.out.println(num);
		tr.compare(num);

	}
	public String testRandom(int length) {
		String rd = "qwertyuioplkjhgfdsazxcvbnmMNBVCXZASDFGHJKLPOIUYTREWQ0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(rd.length()-1);
			sb.append(rd.charAt(number));
			
		}
		return sb.toString();
	}
	public void compare(String num) {
		Scanner scan = new Scanner(System.in);
		System.out.print("请输入：");
		String test = scan.next();
		if(test.equalsIgnoreCase(num)) {
			System.out.println("输入的验证码正确！！");
		}else {
			System.out.println("输入的验证码不正确！！");
		}
	}

}
