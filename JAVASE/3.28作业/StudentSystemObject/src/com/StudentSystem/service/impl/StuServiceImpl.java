package com.StudentSystem.service.impl;

import com.StudentSystem.Exception.AddException;
import com.StudentSystem.Exception.LoginException;
import com.StudentSystem.Exception.ReviseException;
import com.StudentSystem.User.*;
import com.StudentSystem.service.StuService;
import com.StudentSystem.view.impl.StuViewImpl;

public class StuServiceImpl implements StuService {
	
	Admin[] ad = new Admin[5];
	Student[] stu = new Student[10];
	
	public StuServiceImpl() {
		// TODO Auto-generated constructor stub
		Admin admin = new Admin("admin", "admin");
		ad[0] = admin;
		
		Student student = new Student(1 , "huqisheng", "nv", 12, "chuzhong", "riben", "250", "250@250");
		stu[0] = student;
		
	}
	
	@Override
	public void logininformation(String username, String password)throws LoginException {
		// TODO Auto-generated method stub
		boolean usernameexit = false;
		for (int i = 0; i < ad.length; i++) {
			if(ad[i] == null) {
				continue;
			}
			if(ad[i].username.equals(username)) {
				usernameexit = true; 
				if(ad[i].password.equals(password)) {
					System.out.println("登陆成功！！");
					System.out.println("欢迎您的回来：" + username);
					break;
				}else {
					throw new LoginException("输入的用户名或密码错误！！！！！");
				}
			}
		}
		if(!usernameexit) {
			throw new LoginException("输入的用户名不存在");
		}
		
	}
	@Override
	public boolean isusernameexit(String username)throws LoginException {
		// TODO Auto-generated method stub
		boolean usernameexit = false;
		for (int i = 0; i < ad.length; i++) {
			if(ad[i] == null) {
				continue;
			}
			if(ad[i].username.equals(username)) {
				return true; 
			}
		}
		throw new LoginException("输入的用户名不存在");
	}
	
	
	
	@Override
	public void addinformation(int id, String name, String sex, int age, String school, String address, String phone,
			String email)throws AddException {
		// TODO Auto-generated method stub
		boolean isid = false;
		for (int i = 0; i < stu.length; i++) {
			if(stu[i] == null) {
				continue;
			}
			if(stu[i].id == id) {
				isid = false;
				break;
			}
		}
		if(isid) {
			throw new AddException("该ID已经存在！！！");
		}
		Student student2 = new Student(id, name, sex, age, school, address, phone, email);
		stu[1] = student2;
		
	}
	@Override
	public boolean isid(int id) throws LoginException {
		// TODO Auto-generated method stub
		boolean isid = true;
		for (int i = 0; i < stu.length; i++) {
			if(stu[i] == null) {
				continue;
			}
			if(stu[i].id == id) {
				throw new LoginException("该ID已经存在！！");

			}
		}
		return true;
	}
	@Override
	public void findinformation() {
		// TODO Auto-generated method stub
		for (int i = 0; i < stu.length; i++) {
			System.out.println(stu[i].id + "|" + "\t" + stu[i].name + "|" + "\t" + stu[i].sex + "|" + "\t" + stu[i].age + "|" + "\t" + stu[i].school + "|" + "\t" + stu[i].address + "|" + "\t" + stu[i].phone + "|" + "\t" + stu[i].email);
			if(stu[i] == null) {
				continue;
			}
		}
	}
	
	
	@Override
	public void reviseinformation(int id, String text, String newtext) {
		// TODO Auto-generated method stub
		boolean isidexit = true;
		for (int i = 0; i < stu.length; i++) {
			if(stu[i] == null) {
				continue;
			}
			if(stu[i].id == id) {
				isidexit = false;
				if(text.equals("name")) {
					stu[i].name = newtext;
				}else if(text.equals("sex")) {
					stu[i].sex = newtext;
				}else if(text.equals("school")) {
					stu[i].school = newtext;
				}else if(text.equals("address")) {
					stu[i].address = newtext;
				}else if(text.equals("phone")) {
					stu[i].phone = newtext;
				}else if(text.equals("email")) {
					stu[i].email = newtext;
				}
			}
		}
	}

	@Override
	public boolean isidexit(int id) throws ReviseException {
		// TODO Auto-generated method stub
		boolean isidexit = false;
		for (int i = 0; i < stu.length; i++) {
			if(stu[i] == null) {
				continue;
			}
			if(stu[i].id == id) {
				return true;
			}
		}
		throw new ReviseException("修改的ID不存在！！");
	}







}
