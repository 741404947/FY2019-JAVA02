package com.neuedu2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileoutin {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
			TestFileoutin tf = new TestFileoutin();
			//tf.testFileOutputStream();
			//tf.testFileInputStream();
			tf.testFileCopy();
		}

	
	
	/**
	 * @param args
	 * �����--->�������ļ����
	 */
	public void testFileOutputStream() {
		//����һ���ַ���
		String str = "helloword";
		//���ʵ��ļ�·��
		File file = new File("D:\\JAVAEE\\filetest.txt");
		//����Ҫ����ļ��Ķ���
		FileOutputStream fops  = null;
		try {
			if(!file.exists()) {//�ж��ļ��Ƿ���ڣ��������������ļ���
				file.createNewFile();
			}
			fops = new FileOutputStream(file);
			//���д������
			fops.write(str.getBytes());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fops != null) {//�жϳ����Ƿ��������������رգ�
				try {
					fops.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	
	/**
	 * ������--->���ļ����뵽������
	 */
	public void testFileInputStream() {
		FileInputStream fips = null;
		File file = new File("D:\\JAVAEE\\filetest.txt");
		try {
			fips = new FileInputStream(file);
			//�����ļ��е��ֽڣ������Ƕ�����һ���ֽڣ�����Ҫ��ѭ��
			int result =fips.read();
			while(result != -1) {//read�����ķ����Ƕ�����һ�������ֽڣ����ж��Ƿ��������ֽڣ����û�������ֽ������Ϊ-1
				//�������������ASCII��ת�����ֽ�
				System.out.println((char)result);
				result = fips.read();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fips != null) {
				try {
					fips.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	/**
	 * �ļ��ĸ���
	 * �ļ�1--->����---> �ļ�2
	 */
	public void testFileCopy() {
		FileInputStream fips = null;
		FileOutputStream fops = null;
		File file2  = new File("D:\\JAVAEE\\filetest2.txt");
		try {
			//�����ļ�1�������ֽ�
			fips = new FileInputStream("D:\\JAVAEE\\filetest.txt");
			if(!file2.exists()) {
				file2.createNewFile();
			}
			//д���ļ�2�����ݣ�Ĭ����false�Ǹ��ǣ�true������
			fops = new FileOutputStream(file2, true);
			
			//�ȶ��� ���� ��д��
			int result = fips.read();
			while(result != -1) {
				fops.write(result);
				result = fips.read();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try {
					if(fips != null) {
							fips.close();
					}
					if(fops != null) {
						fops.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
		
	}

}
