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
		System.out.println("----------------------���ĳ���Ʒ�ϵͳ���û���½------------------------");
		System.out.println("1.��½" + "\t" + "2.ע��");
		System.out.println("------------------------------------------------------------------------------------");
	}
	public static void choose(UserBizImpl[] user) {
		System.out.print("�����룺");
		Scanner scan = new Scanner(System.in);
		int opj = scan.nextInt();
		if(opj == 1) {
			login(user);
		}else if (opj == 2) {
			register();
		}else {
			System.out.println("��������ֲ���ȷ���������������룺");
			choose(user);
		}
	}
	public static void login(UserBizImpl[] user) {
		Scanner scan = new Scanner(System.in);
		System.out.print("�������û�����");
		String username = scan.nextLine();
		
		System.out.print("���������룺");
		String password = scan.nextLine();
		
		for (int i = 0; i < user.length; i++) {
		/*if(user[i] == null) {
				continue;
			}
			if(username.equals(user[i].username) && password.equals(user[i].password)) {
				System.out.println("��½�ɹ�������");
				System.out.println("��ӭ����" + username);
				break;
			}else {
				System.out.println("������û��������벻��ȷ���������������룺");
				login(user);
			}*/
			UserBizImpl text_login = new UserBizImpl();
			text_login.login(user[i].username, user[i].password);
		}
	}
	


	public static void register() {
		Scanner scan = new Scanner(System.in);
		UserBizImpl ubi = new UserBizImpl();
		
		System.out.print("��ע�����û�����");
		String username = scan.nextLine();
		
		System.out.print("������������룺");
		String password = scan.nextLine();
		
		System.out.print("���ٴ�����������룺");
		String password2 = scan.nextLine();
		
		System.out.print("��ʵ������");
		String name = scan.nextLine();
		
		System.out.print("�������䣺");
		String email = scan.nextLine();
	}
	
}
