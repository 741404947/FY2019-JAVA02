package com.neuedu;
import java.util.Scanner;
public class BillingSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		nav();
		choose();
	}




	public static void nav() {
		System.out.println("----------------------���ĳ���Ʒ�ϵͳ���û���½------------------------");
		System.out.println("1.��½" + "\t" + "2.ע��" + "\t" + "3.�˳�");
		System.out.println("------------------------------------------------------------------------------------");
	}
	public static void choose() {
		System.out.print("�����룺");
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
			System.out.println("��������ֲ���ȷ���������������룺");
			choose();
		}
		
	}
	
	
}
