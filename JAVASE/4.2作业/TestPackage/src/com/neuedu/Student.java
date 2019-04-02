package com.neuedu;

public class Student {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B b = new B();
		b.text();
	}
	void text() {
		System.out.println("A");
	}

}

class B extends Student{
	void text() {
		super.text();
		System.out.println("B");
	}
}
