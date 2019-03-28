package com.StudentSystem.view.impl;

import java.util.Scanner;

import com.StudentSystem.service.impl.StuServiceImpl;
import com.StudentSystem.view.StuView;

public  class StuViewImpl implements StuView {
	
	StuServiceImpl ssi = new StuServiceImpl();
	
	@Override
	public void login() {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		System.out.print("请输入用户名：");
		String username = scan.nextLine();
		boolean isusernameexit = ssi.isusernameexit(username);
		if(isusernameexit) {
			System.out.print("请输入密码：");
			String password = scan.nextLine();	
			
			ssi.logininformation(username, password);
		}
	}

	@Override
	public void information() {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		System.out.print("请输入学生的ID:" );
		int id = scan.nextInt();
		scan.nextLine();
		boolean isid = ssi.isid(id);
		if(isid) {
			System.out.print("请输入学生的姓名：");
			String name = scan.nextLine();
			
			System.out.print("请输入学生的性别：");
			String sex = scan.nextLine();
			
			System.out.print("请输入学生的年龄:");
			int age = scan.nextInt();
			scan.nextLine();
			
			System.out.print("请输入学生的学历（初中，高中，本科）：");
			String school = scan.nextLine();
			
			System.out.print("请输入学生的地址：");
			String address = scan.nextLine();
			
			System.out.print("请输入学生的手机号码：");
			String phone = scan.nextLine();
			
			System.out.print("请输入学生的邮箱：");
			String email = scan.nextLine();

			System.out.println("数据已经自动保存！！！");
			ssi.addinformation(id, name, sex, age, school, address, phone, email);
		}
	}
	@Override
	public void findinfor() {
		// TODO Auto-generated method stub
		System.out.println("id" + "|" + "\t" + "name" + "|" + "\t" + "\t" + "sex" + "|" + "\t" + "age" + "|" + "\t" + "school" + "|" + "\t" + "address" + "|"  + "\t"+ "phone" + "|" + "\t" + "email");
		ssi.findinformation();
	}
	@Override
	public void revise_infor() {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("请输入要修改的ID：");
		int id = scan.nextInt();
		scan.nextLine();
		boolean isidexit = ssi.isidexit(id);
		if(isidexit) {
				System.out.print("请输入要修改的属性：");
				String text = scan.nextLine();
				
				System.out.print("请输入要修改后的值是：");
				String newtext = scan.nextLine();
				
				System.out.println("修改成功！！！");
				System.out.println("系统自动返回上一级……");
				ssi.reviseinformation(id, text, newtext);
		}
	}
}
