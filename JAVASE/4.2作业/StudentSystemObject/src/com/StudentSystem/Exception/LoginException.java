package com.StudentSystem.Exception;

public class LoginException extends RuntimeException{

	public LoginException(String string) {
		// TODO Auto-generated constructor stub
		System.out.println("输入的用户名不存在!!!!");
	}

}
