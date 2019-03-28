package com.StudentSystem;

import java.util.Scanner;
import com.StudentSystem.view.impl.*;

public class StudentSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentSystem.nav();
		StudentSystem.login();
		StudentSystem.nav_two();
		StudentSystem.login_two();
		
	}
	
	public static void nav(){
		System.out.println("------------------" + "欢迎登陆学生管理系统" + "-------------------");
		System.out.println("1.登陆" + "2.退出");
		System.out.println("-----------------------------------");
		
	}

	public static void login(){
		Scanner scen = new Scanner(System.in);
		System.out.print("请选择：");
		int opr = scen.nextInt();
		if(opr == 1){
			System.out.println("欢迎登陆==>");
			StuViewImpl svi = new StuViewImpl();
			svi.login();
		}else if(opr == 2){
			System.exit(0);
			
		}else{
			System.out.println("输入错误!!!!请重新输入");
			login();//递归调用
		}
	}
	
	public static void nav_two(){
		System.out.println("-------------------" + "请选择要操作的信息对应数字" + "-------------------");
		System.out.println("1.查看学生成绩" + "2.添加学生成绩" + "3.删除学生信息" + "4.修改学生信息" + "5.退出");
		System.out.println("-----------------------------------");
	}
	
	public static void login_two(){
		System.out.print("请输入：");
		Scanner scan = new Scanner(System.in);
		int opr = scan.nextInt();
		scan.nextLine();
		if(opr == 1){
			//查看信息
			StuViewImpl svi = new StuViewImpl();
			svi.findinfor();
			nav_two();
			login_two();
		}else if(opr == 2){
			//添加信息
			StuViewImpl svi = new StuViewImpl();
			svi.information();
			nav_two();
			login_two();
		}else if(opr == 3){
			//删除信息
			
		}else if(opr == 4){
			//修改信息
			revise();
			nav_thire();
		}else if(opr == 5){
			System.exit(0);
			
		}else{
			System.out.println("输入错误!!!!请重新输入");
			login_two();//递归调用
		}
		
	}
	public static void revise(){
		System.out.println("---------------------------------------------------------");
		System.out.println("1.根据id修改学生全部信息" + "2.根据id修改学生部分信息" + "3.返回上一级目录" + "4.系统退出");
		System.out.println("---------------------------------------------------------");
		
	}
	public static void nav_thire(){
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入：");
		//scan.nextLine();
		int opr = scan.nextInt();
		
		if(opr == 1) {
			//1.根据id修改学生全部信息
			
			
		}else if(opr == 2) {
			//2.根据id修改学生部分信息
			StuViewImpl svi = new StuViewImpl();
			svi.revise_infor();
			
		}else if(opr == 3) {
			//3.返回上一级目录
			nav_two();
			login_two();
			
		}else if(opr == 4) {
			//4.系统退出
			System.exit(0);
		}
	}
}
