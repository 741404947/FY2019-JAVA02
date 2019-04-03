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
	 * 将学生对象写到文件中，       序列化！！
	 */
	public static void testWriteSerializable() {
		 //创建一个对象---->需要实现一个序列化接口
		Student stu = new Student(1, "许文杰", 25);
		//向上转型
		OutputStream ops = null;
		//调用一个写入对象的构造方法
		ObjectOutputStream oops = null;
		
		try {
			ops = new FileOutputStream("D:\\JAVAEE\\filestuinfor.txt");
			oops = new ObjectOutputStream(ops);
			//写出对象
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
	 * 对齐反序列化，让其打印出来
	 * 因为序列化时文本是乱码
	 * 所有要反序列化---->就是读入方法
	 * 
	 */
	public static void testReadSerializable() {
		
		InputStream ips = null;
		ObjectInputStream oips = null;
		
		try {
			ips = new FileInputStream("D:\\JAVAEE\\filestuinfor.txt");
			oips = new ObjectInputStream(ips);
			//读入到程序中
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
