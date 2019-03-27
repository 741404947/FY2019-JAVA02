package com.neuedu;
import java.util.Scanner;
public class BillingSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		nav();
		choose();
	}




	public static void nav() {
		System.out.println("----------------------完成某个计费系统的用户登陆------------------------");
		System.out.println("1.登陆" + "\t" + "2.注册" + "\t" + "3.退出");
		System.out.println("------------------------------------------------------------------------------------");
	}
	public static void choose() {
		System.out.print("请输入：");
		Scanner scan = new Scanner(System.in);
		int opj = scan.nextInt();
		if(opj == 1) {
			UserViewImpl uvimpl = new UserViewImpl();
			uvimpl.login();
		}else if (opj == 2) {
			UserViewImpl uvimpl = new UserViewImpl();
			uvimpl.register();
		}else if(opj == 3) {
			System.exit(0);
		}else {
			System.out.println("输入的数字不正确！！！请重新输入：");
			choose();
		}
		
	}
	
	
}
