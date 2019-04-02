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
	 * 输出流--->程序向文件输出
	 */
	public void testFileOutputStream() {
		//建立一个字符串
		String str = "helloword";
		//访问的文件路径
		File file = new File("D:\\JAVAEE\\filetest.txt");
		//建立要输出文件的对象
		FileOutputStream fops  = null;
		try {
			if(!file.exists()) {//判断文件是否存在；不存在则建立新文件！
				file.createNewFile();
			}
			fops = new FileOutputStream(file);
			//输出写出数据
			fops.write(str.getBytes());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fops != null) {//判断程序是否输出；让输出流关闭！
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
	 * 输入流--->由文件输入到程序中
	 */
	public void testFileInputStream() {
		FileInputStream fips = null;
		File file = new File("D:\\JAVAEE\\filetest.txt");
		try {
			fips = new FileInputStream(file);
			//读出文件中的字节；由于是读的是一个字节，所有要有循环
			int result =fips.read();
			while(result != -1) {//read（）的方法是读出下一个数据字节，并判断是否还有数据字节；如果没有数据字节则读入为-1
				//将读入进来的是ASCII码转换成字节
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
	 * 文件的复制
	 * 文件1--->程序---> 文件2
	 */
	public void testFileCopy() {
		FileInputStream fips = null;
		FileOutputStream fops = null;
		File file2  = new File("D:\\JAVAEE\\filetest2.txt");
		try {
			//读入文件1的数据字节
			fips = new FileInputStream("D:\\JAVAEE\\filetest.txt");
			if(!file2.exists()) {
				file2.createNewFile();
			}
			//写出文件2的数据；默认是false是覆盖，true是增加
			fops = new FileOutputStream(file2, true);
			
			//先读入 遍历 再写出
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
