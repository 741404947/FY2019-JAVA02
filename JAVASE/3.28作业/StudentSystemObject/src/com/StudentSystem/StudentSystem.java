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
		System.out.println("------------------" + "��ӭ��½ѧ������ϵͳ" + "-------------------");
		System.out.println("1.��½" + "2.�˳�");
		System.out.println("-----------------------------------");
		
	}

	public static void login(){
		Scanner scen = new Scanner(System.in);
		System.out.print("��ѡ��");
		int opr = scen.nextInt();
		if(opr == 1){
			System.out.println("��ӭ��½==>");
			StuViewImpl svi = new StuViewImpl();
			svi.login();
		}else if(opr == 2){
			System.exit(0);
			
		}else{
			System.out.println("�������!!!!����������");
			login();//�ݹ����
		}
	}
	
	public static void nav_two(){
		System.out.println("-------------------" + "��ѡ��Ҫ��������Ϣ��Ӧ����" + "-------------------");
		System.out.println("1.�鿴ѧ���ɼ�" + "2.���ѧ���ɼ�" + "3.ɾ��ѧ����Ϣ" + "4.�޸�ѧ����Ϣ" + "5.�˳�");
		System.out.println("-----------------------------------");
	}
	
	public static void login_two(){
		System.out.print("�����룺");
		Scanner scan = new Scanner(System.in);
		int opr = scan.nextInt();
		scan.nextLine();
		if(opr == 1){
			//�鿴��Ϣ
			StuViewImpl svi = new StuViewImpl();
			svi.findinfor();
			nav_two();
			login_two();
		}else if(opr == 2){
			//�����Ϣ
			StuViewImpl svi = new StuViewImpl();
			svi.information();
			nav_two();
			login_two();
		}else if(opr == 3){
			//ɾ����Ϣ
			
		}else if(opr == 4){
			//�޸���Ϣ
			revise();
			nav_thire();
		}else if(opr == 5){
			System.exit(0);
			
		}else{
			System.out.println("�������!!!!����������");
			login_two();//�ݹ����
		}
		
	}
	public static void revise(){
		System.out.println("---------------------------------------------------------");
		System.out.println("1.����id�޸�ѧ��ȫ����Ϣ" + "2.����id�޸�ѧ��������Ϣ" + "3.������һ��Ŀ¼" + "4.ϵͳ�˳�");
		System.out.println("---------------------------------------------------------");
		
	}
	public static void nav_thire(){
		Scanner scan = new Scanner(System.in);
		System.out.println("�����룺");
		//scan.nextLine();
		int opr = scan.nextInt();
		
		if(opr == 1) {
			//1.����id�޸�ѧ��ȫ����Ϣ
			
			
		}else if(opr == 2) {
			//2.����id�޸�ѧ��������Ϣ
			StuViewImpl svi = new StuViewImpl();
			svi.revise_infor();
			
		}else if(opr == 3) {
			//3.������һ��Ŀ¼
			nav_two();
			login_two();
			
		}else if(opr == 4) {
			//4.ϵͳ�˳�
			System.exit(0);
		}
	}
}
