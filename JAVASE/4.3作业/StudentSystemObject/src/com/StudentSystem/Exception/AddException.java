package com.StudentSystem.Exception;

public class AddException extends RuntimeException {

	public AddException(String string) {
		// TODO Auto-generated constructor stub
		System.out.println("已经有了此ID号！！！");
	}

}
