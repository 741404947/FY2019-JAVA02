package com.neuedu2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TestBufferRW {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//testBufferReader();
		testBufferWrite();
		
	}
	
	public static void testBufferReader() {
		//字节输入流
		FileInputStream fips = null;
		//字节转换字符
		InputStreamReader ipsr = null;
		//字符输入流
		BufferedReader br = null;
		try {
			fips = new FileInputStream("D:\\JAVAEE\\filetest.txt");
			ipsr =new InputStreamReader(fips);
			br = new BufferedReader(ipsr);
			String result = null;
			while((result = (br.readLine())) != null) {
				System.out.println(result);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(br !=null) {
					br.close();
				}
				if(ipsr !=null) {
					ipsr.close();
				}
				if(fips !=null) {
					fips.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	public static void testBufferWrite() {
		FileOutputStream fops = null;
		OutputStreamWriter opsw = null;
		BufferedWriter bw = null;
		String st1 = "qwertyuioplkjhgfdsazxcvbnm";
		String st2 = "ASDFGHJKLMNBVCXZQWERTYUIOP";
		String st3 = "1234567890";
		try {
			fops = new FileOutputStream("D:\\JAVAEE\\testBufferWrite.txt");
			opsw = new OutputStreamWriter(fops);
			bw = new BufferedWriter(opsw);
			bw.write(st2);
			bw.newLine();//换行符
			bw.write(st1);
			bw.newLine();
			bw.write(st3);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//关闭流--->就近原则，先关最外边的，依次关闭
			try {
				if(bw != null) {
					bw.close();
				}
				if(opsw != null) {
					opsw.close();
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
