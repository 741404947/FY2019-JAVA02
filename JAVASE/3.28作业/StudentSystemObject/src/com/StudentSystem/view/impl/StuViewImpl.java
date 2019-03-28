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
		
		System.out.print("�������û�����");
		String username = scan.nextLine();
		boolean isusernameexit = ssi.isusernameexit(username);
		if(isusernameexit) {
			System.out.print("���������룺");
			String password = scan.nextLine();	
			
			ssi.logininformation(username, password);
		}
	}

	@Override
	public void information() {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		System.out.print("������ѧ����ID:" );
		int id = scan.nextInt();
		scan.nextLine();
		boolean isid = ssi.isid(id);
		if(isid) {
			System.out.print("������ѧ����������");
			String name = scan.nextLine();
			
			System.out.print("������ѧ�����Ա�");
			String sex = scan.nextLine();
			
			System.out.print("������ѧ��������:");
			int age = scan.nextInt();
			scan.nextLine();
			
			System.out.print("������ѧ����ѧ�������У����У����ƣ���");
			String school = scan.nextLine();
			
			System.out.print("������ѧ���ĵ�ַ��");
			String address = scan.nextLine();
			
			System.out.print("������ѧ�����ֻ����룺");
			String phone = scan.nextLine();
			
			System.out.print("������ѧ�������䣺");
			String email = scan.nextLine();

			System.out.println("�����Ѿ��Զ����棡����");
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
		System.out.print("������Ҫ�޸ĵ�ID��");
		int id = scan.nextInt();
		scan.nextLine();
		boolean isidexit = ssi.isidexit(id);
		if(isidexit) {
				System.out.print("������Ҫ�޸ĵ����ԣ�");
				String text = scan.nextLine();
				
				System.out.print("������Ҫ�޸ĺ��ֵ�ǣ�");
				String newtext = scan.nextLine();
				
				System.out.println("�޸ĳɹ�������");
				System.out.println("ϵͳ�Զ�������һ������");
				ssi.reviseinformation(id, text, newtext);
		}
	}
}
