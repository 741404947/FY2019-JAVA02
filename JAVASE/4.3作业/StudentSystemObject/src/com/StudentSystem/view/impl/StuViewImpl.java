package com.StudentSystem.view.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import com.StudentSystem.service.impl.StuServiceImpl;
import com.StudentSystem.view.StuView;

public  class StuViewImpl implements StuView {
	
	
	//单例模式案件
	StuServiceImpl ssi = StuServiceImpl.getInstance();
	//StuViewImpl svi = new StuViewImpl();
	
	
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
			
			String num = ssi.testRandom(4);
			System.out.print(num);
			
			System.out.print("请输入验证码（不区分大小写）：");
			String code = scan.next();
			boolean iscode = ssi.iscodeexit(code, num);
			if(iscode) {
				ssi.logininformation(username, password, code, num);
			}else {
				login();
			}
		}
	}
	
	
	@Override
	public void information() {
		// TODO Auto-generated method stub
		Date date = new Date(System.currentTimeMillis());
		Scanner scan = new Scanner(System.in);
		
		System.out.print("请输入学生的ID:" );
		int id = scan.nextInt();
		scan.nextLine();
		boolean isid = ssi.isid(id);
		if(isid) {
			System.out.print("请输入学生的姓名：");
			String name = scan.nextLine();
			
			System.out.print("请输入学生的性别：");
			System.out.println("1.男" + "2.女");
			String sex = scan.nextLine();
			
		/*	int sex_choose = scan.nextInt();
			if(sex_choose == 1) {
				String sex = Testenum.MAN.getTestEnum();
				
			}else if(sex_choose == 2) {
				String sex = Testenum.WOMAN.getTestEnum();
			}else {
				String sex = null;
			}*/
			
			System.out.print("请输入学生的年龄:");
			int age = scan.nextInt();
			scan.nextLine();
			
			System.out.print("请输入学生的学历（1.初中，2.高中，3.本科）：");
			String school = scan.nextLine();
			
			
	/*		int school_choose = scan.nextInt();
			if(school_choose == 1) {
				String school = Testenum.PRIMARY.getTestEnum();
			}else if(school_choose == 2) {
				String school = Testenum.MIDDLE.getTestEnum();
			}else if(school_choose == 3) {
				String school = Testenum.HIGH.getTestEnum();
			}
			*/
			
			System.out.print("请输入学生的地址：");
			String address = scan.nextLine();
			
			System.out.print("请输入学生的手机号码：");
			String phone = scan.nextLine();
			
			System.out.print("请输入学生的邮箱：");
			String email = scan.nextLine();
			
			System.out.print("学生成绩：");
			int score = scan.nextInt();
			
			System.out.print("注册时间：");
			SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
			String _date = format.format(date);
			System.out.print(_date);

			System.out.println("数据已经自动保存！！！");
			
			ssi.addinformation(id, name, sex, age, school, address, phone, email, score, _date);
		}
	}
	@Override
	public void findinfor() {
		// TODO Auto-generated method stub
		System.out.println("id" + "|" + "\t" + "name" + "|" + "\t" + "\t" + "sex" + "|" + "\t" + "age" + "|" + "\t" + "school" + "|" + "\t" + "address" + "|"  + "\t"+ "phone" + "|" + "\t" + "email" + "|" + "\t" + "score" + "|" + "\t" +"date");
		ssi.findinformation();
	}
	@Override
	public void revise_infor() {
		// TODO Auto-generated method stub
		Date date = new Date(System.currentTimeMillis());
		Scanner scan = new Scanner(System.in);
		System.out.print("请输入要修改的ID：");
		int id = scan.nextInt();
		scan.nextLine();
		ssi.informationTwoFind(id);
		boolean isidexit = ssi.isidexit(id);
		if(isidexit) {
				System.out.print("请输入要修改的属性：");
				String text = scan.nextLine();
				
				System.out.print("请输入要修改后的值是：");
				String newtext = scan.nextLine();
				
				SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
				String _date = format.format(date);
				System.out.print(_date);
				
				System.out.println("修改成功！！！");
				System.out.println("系统自动返回上一级……");
				ssi.reviseinformation(id, text, newtext , _date);
		}
	}
	public void delete_infor() {
		Scanner scan = new Scanner(System.in);
		System.out.print("请输入要删除的学生信息的ID：");
		int id = scan.nextInt();
		boolean isdel = ssi.isdel(id);
		if(isdel) {
			ssi.deleteinformation(id);
			System.out.println("已经删除！！");
		}
		
	}
	

}
 enum Testenum{
	MAN("男"),WOMAN("女"),PRIMARY("初级"),MIDDLE("中级"),HIGH("高级");
	 private String testenum;
	  Testenum(String testenum) {
		// TODO Auto-generated constructor stub
		  this.testenum = testenum;
	  }
	  public String getTestEnum() {
			return testenum;
		}
}
