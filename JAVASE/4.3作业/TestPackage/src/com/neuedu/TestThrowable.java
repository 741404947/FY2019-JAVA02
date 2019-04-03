package com.neuedu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestThrowable {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		TestThrowable te = new TestThrowable();
		//te.test1();
		//te.test3();
		te.test4(-2);
	}
	public void test1() {
		try {
			test2();
		}catch(IOException e) {
			System.out.println("服务器繁忙！！！");
		}finally {
			System.out.println("最终输出结果……");
		}
		
	}
	public void test2() throws IOException{
		File file = new File("file");
		file.createNewFile();		
	}
	
	public void test3() {
		try {
			int a = 3/0;
			System.out.println("---------try---------");
		}catch(RuntimeException e) {
			System.out.println("服务器繁忙！！！！");
		}finally {
			System.out.println("最终输入的！！！！");
		}
	}
	public int test4(int a)throws  FileNotFoundException{
		if(a < 0) {
			throw new FileNotFoundException();
		}
		return a;
		
	}
}
