package com.neuedu;

public class RegisterException extends RuntimeException {
	public RegisterException() {
		System.out.println("ע��ʱ����������֮��Ĵ���������ע�ᡭ��");
	}
	public RegisterException(String a) {
		super(a);
		System.out.println("ע��ʱ����������֮��Ĵ���������ע�ᡭ��");
	}
	
}
