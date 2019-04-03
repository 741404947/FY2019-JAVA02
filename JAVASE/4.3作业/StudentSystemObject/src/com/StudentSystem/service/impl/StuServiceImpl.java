package com.StudentSystem.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import com.StudentSystem.Exception.AddException;
import com.StudentSystem.Exception.DelException;
import com.StudentSystem.Exception.FIndException;
import com.StudentSystem.Exception.LoginException;
import com.StudentSystem.Exception.ReviseException;
import com.StudentSystem.User.*;
import com.StudentSystem.service.StuService;
import com.StudentSystem.view.impl.StuViewImpl;

/**
 * @author 74140
 *单例案件模式
 */
public class StuServiceImpl implements StuService {
	private static StuServiceImpl ssi;
	
	Admin[] ad = new Admin[5];
	 static List<Student> stu = new ArrayList<Student>();

	private StuServiceImpl() {
		// TODO Auto-generated constructor stub
		Admin admin = new Admin("admin", "admin");
		ad[0] = admin;
		
		Student student = new Student(1 , "huqisheng", "nv", 12, "chuzhong", "riben", "250", "250@250", 59, "19-4-1 10:55:05");
		stu.add(student);
	}
	
	public synchronized static StuServiceImpl getInstance() {
		 if(ssi == null) {
			 ssi = new StuServiceImpl();
		 }
		return ssi;
		
	}
	
	public String testRandom(int length) {
		String rd = "qwertyuioplkjhgfdsazxcvbnmMNBVCXZASDFGHJKLPOIUYTREWQ0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(rd.length()-1);
			sb.append(rd.charAt(number));
			
		}
		return sb.toString();
	}
	
	@Override
	public void logininformation(String username, String password, String code , String num)throws LoginException {
		// TODO Auto-generated method stub
		boolean usernameexit = false;
		boolean iscode = true;
		for (int i = 0; i < ad.length; i++) {
			if(ad[i] == null) {
				continue;
			}
			if(ad[i].username.equals(username)) {
				usernameexit = true; 
				if(ad[i].password.equals(password)) {
					if(code.equalsIgnoreCase(num)) {
						System.out.println("验证成功！！");
						System.out.println("登陆成功！！");
						System.out.println("欢迎您的回来：" + username);
						break;
					}else {
						iscode = false;
						System.out.println("输入的验证码不正确！！");
					}
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
	
	public boolean iscodeexit(String code ,  String num){
		// TODO Auto-generated method stub
		boolean iscode = false;
		for (int i = 0; i < ad.length; i++) {
			if(ad[i] == null) {
				continue;
			}
			if(code.equalsIgnoreCase(num)) {
				return true; 
			}
		}
		System.out.println("验证码错误！！");
		return false;
	}
	
	
	@Override
	public void addinformation(int id, String name, String sex, int age, String school, String address, String phone,
			String email, int score, String _date)throws AddException {
		// TODO Auto-generated method stub
		boolean isid = true;
		for (int i = 0; i < stu.size(); i++) {
			if(stu == null) {
				continue;
			}
			if(stu.get(i).getId() == id) {
				isid = false;
				break;
			}
		}
		if(!isid) {
			throw new AddException("该ID已经存在！！！");
		}
		for (int i = 0; i < stu.size(); i++) {
			
				Student student2 = new Student(id, name, sex, age, school, address, phone, email, score, _date);
				stu.add(student2);
				break;
		
		}
		
		
		
	}
	@Override
	public boolean isid(int id) throws LoginException {
		// TODO Auto-generated method stub
		boolean isid = true;
		for (int i = 0; i < stu.size(); i++) {
			if(stu == null) {
				continue;
			}
			if(stu.get(i).getId() == id) {
				throw new LoginException("该ID已经存在！！");

			}
		}
		return true;
	}
	@Override
	public void findinformation()throws FIndException {
		// TODO Auto-generated method stub
		for (int i = 0; i < stu.size(); i++) {
			if(stu == null) {
				break;
			}
			System.out.println(stu.get(i).getId() + "|" + "\t" + stu.get(i).getName() + "|" + "\t" + "\t" + stu.get(i).getSex() + "|" + "\t" 
										+ stu.get(i).getAge() + "|" + "\t" + stu.get(i).getSchool() + "|" + "\t" 
										+ stu.get(i).getAddress() + "|" + "\t" + stu.get(i).getPhone() + "|" + "\t" 
										+ stu.get(i).getEmail() + "|" + "\t" + stu.get(i).getScore() + "|" + "\t" +stu.get(i).get_date());
		}
	}
	
	public void informationArray1() {
		Collections.sort(stu);
		//System.out.println(stu);
	}
	public void informationArray2() {
		Collections.sort(stu);
		Collections.reverse(stu);
		//System.out.println(stu);
	}
	
	public Student informationTwoFind( int m) {
		//Collections.sort(stu);
		Student studentsp = new Student();
		for (int i = 0; i < stu.size(); i++) {
			for (int j = 0; j < stu.size()-i-1; j++) {
				if(stu.get(j+1) != null) {
					if(stu.get(j).getId() > stu.get(j+1).getId()) {				
						studentsp = stu.get(j);
						stu.set(j,stu.get(j+1));
						stu.set(j+1, studentsp);
					}
				}	
			}
		}
		
		
		int n = 0;
		int x = 0;
		int y = stu.size()-1;
		int k = (x+y)/2;
		/*Scanner scan = new Scanner(System.in);
		System.out.println("请输入你要查询的ID：");
		int m = scan.nextInt();*/
		
		while(x <= y) {
			n++;
			if(stu.get(k).getId() > m) {
				y = k-1;
			}else if(stu.get(k).getId() < m) {
				x = k+1;
			}else {
				System.out.println(stu.get(k).getId() + "|" + "\t" + stu.get(k).getName() + "|" + "\t" + "\t" + stu.get(k).getSex() + "|" + "\t" 
						+ stu.get(k).getAge() + "|" + "\t" + stu.get(k).getSchool() + "|" + "\t" 
						+ stu.get(k).getAddress() + "|" + "\t" + stu.get(k).getPhone() + "|" + "\t" 
						+ stu.get(k).getEmail() + "|" + "\t" + stu.get(k).getScore() + "|" + "\t" +stu.get(k).get_date());
				System.out.println("共进行了" + n + "次循环查到");
				break;
			}
			k = (x+y)/2;
		}
		return stu.get(k);
	}
	
	@Override
	public void reviseinformation(int id, String text, String newtext , String _date) {
		// TODO Auto-generated method stub
		boolean isidexit = true;
		for (int i = 0; i < stu.size(); i++) {
			if(stu == null) {
				continue;
			}
			if(stu.get(i).getId() == id) {
				isidexit = false;
				if(text.equals("name")) {
					stu.get(i).setName(newtext); 
				}else if(text.equals("sex")) {
					stu.get(i).setSex(newtext);
				}else if(text.equals("school")) {
					stu.get(i).setSchool(newtext);
				}else if(text.equals("address")) {
					stu.get(i).setAddress(newtext);
				}else if(text.equals("phone")) {
					stu.get(i).setPhone(newtext);
				}else if(text.equals("email")) {
					stu.get(i).setEmail(newtext);
				}
			}
			stu.get(i).set_date(_date);
		}
	}

	@Override
	public boolean isidexit(int id) throws ReviseException {
		// TODO Auto-generated method stub
		boolean isidexit = false;
		for (int i = 0; i < stu.size(); i++) {
			if(stu == null) {
				continue;
			}
			if(stu.get(i).getId() == id) {
				return true;
			}
		}
		throw new ReviseException("修改的ID不存在！！");
	}

	@Override
	public void deleteinformation(int id) {
		// TODO Auto-generated method stub
		boolean isdel = false;
		for (int i = 0; i < stu.size(); i++) {
			if(stu == null) {
				continue;
			}
			if(stu.get(i).getId() == id) {
				isdel = true;
				stu.remove(i);
			}
			//System.out.println(stu[i]);
		}
	
		
	}

	@Override
	public boolean isdel(int id) throws DelException {
		// TODO Auto-generated method stub
		boolean isdel = false;
		for (int i = 0; i < stu.size(); i++) {
			if(stu == null) {
				continue;
			}
			if(stu.get(i).getId() == id) {
				return true;
			}
		}
		throw new DelException("ID不存在！！");
	}

}
