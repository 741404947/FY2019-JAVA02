package com.neuedu;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestClass obj = new TestClass();
		obj.testInteger();
	}
	
	
	public void testInteger() {
		//System.out.println( Integer.MAX_VALUE);  
		//System.out.println(Integer.MIN_VALUE);
		Integer integer = new Integer("123");//java.lang.NumberFormatException
		//System.out.println(integer);
		Integer integer2 = new Integer(25);
		Double d = integer2.doubleValue();
		//System.out.println(d);
		//System.out.println(Integer.parseInt("125"));
		int a = 250;
		Integer aa = Integer.valueOf(a);
		System.out.println(aa);
		/**
		 * 装箱------拆箱
		 */
		//Integer integer3 = new Integer(222);//正常情况下
		int b = new Integer(222);//拆箱 
		double d2 = new Double(2.5);
		
		Integer c = 222;//装箱
		Double d1 = 2.5;
		
	}
	
	public void testDouble() {
		
	}
}
