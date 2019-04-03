package com.StudentSystem.view.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import com.StudentSystem.service.impl.StuServiceImpl;
import com.StudentSystem.view.StuView;

public  class StuViewImpl implements StuView {
	
	
	//����ģʽ����
	StuServiceImpl ssi = StuServiceImpl.getInstance();
	//StuViewImpl svi = new StuViewImpl();
	
	
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
			
			String num = ssi.testRandom(4);
			System.out.print(num);
			
			System.out.print("��������֤�루�����ִ�Сд����");
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
		
		System.out.print("������ѧ����ID:" );
		int id = scan.nextInt();
		scan.nextLine();
		boolean isid = ssi.isid(id);
		if(isid) {
			System.out.print("������ѧ����������");
			String name = scan.nextLine();
			
			System.out.print("������ѧ�����Ա�");
			System.out.println("1.��" + "2.Ů");
			String sex = scan.nextLine();
			
		/*	int sex_choose = scan.nextInt();
			if(sex_choose == 1) {
				String sex = Testenum.MAN.getTestEnum();
				
			}else if(sex_choose == 2) {
				String sex = Testenum.WOMAN.getTestEnum();
			}else {
				String sex = null;
			}*/
			
			System.out.print("������ѧ��������:");
			int age = scan.nextInt();
			scan.nextLine();
			
			System.out.print("������ѧ����ѧ����1.���У�2.���У�3.���ƣ���");
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
			
			System.out.print("������ѧ���ĵ�ַ��");
			String address = scan.nextLine();
			
			System.out.print("������ѧ�����ֻ����룺");
			String phone = scan.nextLine();
			
			System.out.print("������ѧ�������䣺");
			String email = scan.nextLine();
			
			System.out.print("ѧ���ɼ���");
			int score = scan.nextInt();
			
			System.out.print("ע��ʱ�䣺");
			SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
			String _date = format.format(date);
			System.out.print(_date);

			System.out.println("�����Ѿ��Զ����棡����");
			
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
		System.out.print("������Ҫ�޸ĵ�ID��");
		int id = scan.nextInt();
		scan.nextLine();
		ssi.informationTwoFind(id);
		boolean isidexit = ssi.isidexit(id);
		if(isidexit) {
				System.out.print("������Ҫ�޸ĵ����ԣ�");
				String text = scan.nextLine();
				
				System.out.print("������Ҫ�޸ĺ��ֵ�ǣ�");
				String newtext = scan.nextLine();
				
				SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
				String _date = format.format(date);
				System.out.print(_date);
				
				System.out.println("�޸ĳɹ�������");
				System.out.println("ϵͳ�Զ�������һ������");
				ssi.reviseinformation(id, text, newtext , _date);
		}
	}
	public void delete_infor() {
		Scanner scan = new Scanner(System.in);
		System.out.print("������Ҫɾ����ѧ����Ϣ��ID��");
		int id = scan.nextInt();
		boolean isdel = ssi.isdel(id);
		if(isdel) {
			ssi.deleteinformation(id);
			System.out.println("�Ѿ�ɾ������");
		}
		
	}
	

}
 enum Testenum{
	MAN("��"),WOMAN("Ů"),PRIMARY("����"),MIDDLE("�м�"),HIGH("�߼�");
	 private String testenum;
	  Testenum(String testenum) {
		// TODO Auto-generated constructor stub
		  this.testenum = testenum;
	  }
	  public String getTestEnum() {
			return testenum;
		}
}
