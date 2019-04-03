package com.neuedu2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class TestStuObjectInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		testWriteSerializable();
		testReadSerializable();
	}
	
	/**
	 * ��ѧ������д���ļ��У�       ���л�����
	 */
	public static void testWriteSerializable() {
		 //����һ������---->��Ҫʵ��һ�����л��ӿ�
		Student stu = new Student(1, "���Ľ�", 25);
		//����ת��
		OutputStream ops = null;
		//����һ��д�����Ĺ��췽��
		ObjectOutputStream oops = null;
		
		try {
			ops = new FileOutputStream("D:\\JAVAEE\\filestuinfor.txt");
			oops = new ObjectOutputStream(ops);
			//д������
			oops.writeObject(stu);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(oops != null) {
					oops.close();
				}
				if(ops != null) {
					ops.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * ���뷴���л��������ӡ����
	 * ��Ϊ���л�ʱ�ı�������
	 * ����Ҫ�����л�---->���Ƕ��뷽��
	 * 
	 */
	public static void testReadSerializable() {
		
		InputStream ips = null;
		ObjectInputStream oips = null;
		
		try {
			ips = new FileInputStream("D:\\JAVAEE\\filestuinfor.txt");
			oips = new ObjectInputStream(ips);
			//���뵽������
			Object o = oips.readObject();
			if(o instanceof Student) {
				Student s = (Student)o;
				System.out.println(s.getId());
				System.out.println(s.getName());
				System.out.println(s.getAge());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(oips != null) {
					oips.close();
				}
				if(ips != null) {
					ips.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
