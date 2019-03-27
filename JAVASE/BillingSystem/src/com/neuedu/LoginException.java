package com.neuedu;

public class LoginException extends RuntimeException {
	public LoginException() {
		//System.out.println("服务器繁忙，请稍后……");
	}
	public LoginException(String msg) {
		super(msg);
		//System.out.println("服务器繁忙，请稍后……");
	}
}
