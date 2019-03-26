package com.neuedu;
import java.util.Scanner;
public class BillingSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		nav();
		UserBizImpl[] user = new UserBizImpl[5];
		usertest(user);
		choose(user);
	}

	public static void usertest(UserBizImpl[] user) {
		UserBizImpl ubi = new UserBizImpl();
		UserBizImpl ubi2 = new UserBizImpl();
		ubi.username = "admin"; 
		ubi.password = "admin";
		ubi.name =  "Administrator";
		ubi.email = "admin@123.com";
		user[0] = ubi;
		ubi2.username = "tom";
		ubi2.password = "cat";
		ubi2.name = "tomcat";
		ubi2.email = "tomcat@cat.com";
		user[1] = ubi2;
	/*	for (int i = 0; i < user.length; i++) {
			System.out.println(user[i].name);
		}*/
	}
	public static void nav() {
		System.out.println("----------------------完成某个计费系统的用户登陆------------------------");
		System.out.println("1.登陆" + "\t" + "2.注册");
		System.out.println("------------------------------------------------------------------------------------");
	}
	public static void choose(UserBizImpl[] user) {
		System.out.print("请输入：");
		Scanner scan = new Scanner(System.in);
		int opj = scan.nextInt();
		if(opj == 1) {
			login(user);
		}else if (opj == 2) {
			register();
		}else {
			System.out.println("输入的数字不正确！！！请重新输入：");
			choose(user);
		}
	}
	public static void login(UserBizImpl[] user) {
		Scanner scan = new Scanner(System.in);
		System.out.print("请输入用户名：");
		String username = scan.nextLine();
		
		System.out.print("请输入密码：");
		String password = scan.nextLine();
		
		for (int i = 0; i < user.length; i++) {
		/*if(user[i] == null) {
				continue;
			}
			if(username.equals(user[i].username) && password.equals(user[i].password)) {
				System.out.println("登陆成功！！！");
				System.out.println("欢迎您：" + username);
				break;
			}else {
				System.out.println("输入的用户名和密码不正确！！！请重新输入：");
				login(user);
			}*/
			UserBizImpl text_login = new UserBizImpl();
			text_login.login(user[i].username, user[i].password);
		}
	}
	


	public static void register() {
		Scanner scan = new Scanner(System.in);
		UserBizImpl ubi = new UserBizImpl();
		
		System.out.print("请注册新用户名：");
		String username = scan.nextLine();
		
		System.out.print("请输入你的密码：");
		String password = scan.nextLine();
		
		System.out.print("请再次输入你的密码：");
		String password2 = scan.nextLine();
		
		System.out.print("真实姓名：");
		String name = scan.nextLine();
		
		System.out.print("电子邮箱：");
		String email = scan.nextLine();
	}
	
}
