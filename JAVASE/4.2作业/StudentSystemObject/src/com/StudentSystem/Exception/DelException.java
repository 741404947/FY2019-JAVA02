package com.StudentSystem.Exception;

public class DelException extends RuntimeException {
	public DelException(String msg) {
		System.out.println("要删除的ID不存在！！");
	}
}
