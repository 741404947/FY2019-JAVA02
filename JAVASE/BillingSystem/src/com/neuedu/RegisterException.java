package com.neuedu;

public class RegisterException extends RuntimeException {
	public RegisterException() {
		System.out.println("注册时出现了意料之外的错误，请重新注册……");
	}
	public RegisterException(String a) {
		super(a);
		System.out.println("注册时出现了意料之外的错误，请重新注册……");
	}
	
}
