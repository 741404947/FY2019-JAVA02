package com.neuedu;

import java.util.Scanner;

public class TestObject {
	Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestObject obj = new TestObject();
		System.out.println("开始测试：");
		//obj.testHashcode();
		String s2 = "qwqwttesty";
		String n = "t";
		//obj.testIndex(s2, n);
		String s3 = "abcd";
		String s4 = "abcdedas";
		//obj.testequal(s3, s4);
		//obj.testCase();
		//obj.testReverse();
		//obj.testSubstring();
		//obj.testReverse_two();
		/*String s13 = obj.scan.next();
		obj.testSymmetric(s13);*/
		//obj.testSplit();
		obj.testReverse_three();
	}
	public void testHashcode() {
		
		String s1 = scan.next();
		System.out.println(s1.hashCode());
		testHashcode();
	}
	public void testIndex(String s2, String n) {
		int x = (s2.length() - s2.replace(n, "").length())/n.length();
		System.out.println("指定字符" + n + "出现了" + x + "次");
	}
	public void testequal(String s3, String s4) {
		if(s3.hashCode() == s4.hashCode()) {
			System.out.println("=========字符串相等=======");
		}else {
			System.out.println("=========字符串不相等=======");
		}
	}
	public void testCase() {
		String s5 = "jdk";
		System.out.println(s5.toUpperCase());
		String s6 = s5.substring(1);
		System.out.println(s6.toUpperCase());
	}
	public void testReverse() {
		StringBuffer buffer = new StringBuffer("test");
		System.out.println(buffer.reverse());
	}
	public void testSubstring() {
		String s= "name=zhangsan age=18 classNo=090728";//18,20,29,34
		String s7 = s.substring(5,13);
		String s8 = s.substring(18, 20);
		String s9 = s.substring(29);
		System.out.println(s7 + "\t" + s8 + "\t" + s9);
	}
	public void testReverse_two() {
		StringBuffer buffer = new StringBuffer();
		String s10 = "To be or not to be";
		String[] s11 = s10.split(" ");
		for (int i = 0; i < s11.length; i++) {
			System.out.print(s11[i] + "\t");
		buffer.append(s11[i]).reverse();
			System.out.print(buffer + "\t");
		}
	}
	
	public void testReverse_three() {
		StringBuffer buffer = new StringBuffer();
		String x1 = "To be or not to be";
		String[] x2 = x1.split(" ");
		for (int i = 0; i < x2.length; i++) {
			StringBuffer s1 = new StringBuffer(x2[i]);
			System.out.print(s1.reverse() + "\t");
		}
		System.out.println(".");
	}
	
	public void testSymmetric(String s13) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(s13);
		System.out.println(buffer);
		System.out.println(buffer.reverse());
		if(buffer.equals(buffer.reverse())) {
			System.out.println("该字符串是一个对称的！！！");
		}else {
			System.out.println("该字符串不是一个对称的！！！");
		}
	}
	public void testSplit() {
		String s14 = "113@ ere qqq yyui";
		String[] s15 = s14.split("@");
		System.out.print(s15[0]);
		String[] s16 = s15[1].split("  ");
		for (int i = 0; i < s16.length; i++) {
			System.out.println(s16[i]);
		}
	}
}
