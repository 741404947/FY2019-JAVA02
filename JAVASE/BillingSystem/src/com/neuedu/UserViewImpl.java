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
		System.out.println("�������û�����");
		String username = scan.nextLine();
		
		boolean usernameexit = ubimpl.isUsername(username);
		if(usernameexit) {
			System.out.println("���������룺");
			String password = scan.nextLine();
			ubimpl.login(username, password);
		}
	}

	@Override
	public void register() {
		// TODO Auto-generated method stub
		//UserBizImpl ubimpl = new UserBizImpl();
		
		Scanner scan = new Scanner(System.in);
	
		
		System.out.print("��ע�����û�����");
		String username = scan.nextLine();
		boolean isusernameexit = ubimpl.isUsernameexit(username);
		if(isusernameexit) {
				System.out.print("������������룺");
				String password = scan.nextLine();
				
				System.out.print("���ٴ�����������룺");
				String password2 = scan.nextLine();
				boolean ispassword = ubimpl.isPassword(password, password2);
				if(ispassword) {
					System.out.print("��ʵ������");
					String name = scan.nextLine();
					
					System.out.print("�������䣺");
					String email = scan.nextLine();
					
					ubimpl.register(username, password, password2, name, email);
				}
		}
		System.out.println("ע����ɣ�ϵͳ�Զ�������һ�㡭��");
		BillingSystem back = new BillingSystem();
		back.nav();
		back.choose();
	}
}
