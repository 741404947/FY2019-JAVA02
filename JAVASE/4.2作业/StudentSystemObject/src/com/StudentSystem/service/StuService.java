package com.StudentSystem.service;

import com.StudentSystem.Exception.DelException;
import com.StudentSystem.Exception.LoginException;

public interface StuService {
	public void logininformation(String username, String password, String code, String num);
	public boolean isusernameexit(String username)throws LoginException;
	
	public void addinformation(int id, String name, String sex, int age, String school, String address , String phone, String email, int score, String _date);
	public boolean isid(int id)throws LoginException;
	
	public void reviseinformation(int id, String text, String newtext, String _date);
	public boolean isidexit(int id)throws LoginException;
	
	public void findinformation();
	
	public void deleteinformation(int id);
	public boolean isdel(int id)throws DelException;
}
