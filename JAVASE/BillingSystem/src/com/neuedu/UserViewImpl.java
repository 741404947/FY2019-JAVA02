package com.neuedu;
import java.util.Scanner;
public class UserViewImpl implements UserView{
	UserBizImpl ubimpl = new UserBizImpl();
	UserBizImpl ubi = new UserBizImpl();
	@Override
	public void login() {
		// TODO Auto-generated method stub
		//UserBizImpl ubimpl = new UserBizImpl();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入用户名：");
		String username = scan.nextLine();
		
		boolean usernameexit = ubimpl.isUsername(username);
		if(usernameexit) {
			System.out.println("请输入密码：");
			String password = scan.nextLine();
			ubimpl.login(username, password);
		}
	}

	@Override
	public void register() {
		// TODO Auto-generated method stub
		//UserBizImpl ubimpl = new UserBizImpl();
		
		Scanner scan = new Scanner(System.in);
	
		
		System.out.print("请注册新用户名：");
		String username = scan.nextLine();
		boolean isusernameexit = ubimpl.isUsernameexit(username);
		if(isusernameexit) {
				System.out.print("请输入你的密码：");
				String password = scan.nextLine();
				
				System.out.print("请再次输入你的密码：");
				String password2 = scan.nextLine();
				boolean ispassword = ubimpl.isPassword(password, password2);
				if(ispassword) {
					System.out.print("真实姓名：");
					String name = scan.nextLine();
					
					System.out.print("电子邮箱：");
					String email = scan.nextLine();
					
					ubimpl.register(username, password, password2, name, email);
				}
		}
		System.out.println("注册完成，系统自动返回上一层……");
		BillingSystem back = new BillingSystem();
		back.nav();
		back.choose();
	}
}
