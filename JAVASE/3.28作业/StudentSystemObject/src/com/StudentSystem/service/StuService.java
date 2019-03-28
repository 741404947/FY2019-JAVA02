package com.StudentSystem.service;

import com.StudentSystem.Exception.LoginException;

public interface StuService {
	public void logininformation(String username, String password);
	public boolean isusernameexit(String username)throws LoginException;
	
	public void addinformation(int id, String name, String sex, int age, String school, String address , String phone, String email);
	public boolean isid(int id)throws LoginException;
	
	public void reviseinformation(int id, String text, String newtext);
	public boolean isidexit(int id)throws LoginException;
	
	public void findinformation();
}
