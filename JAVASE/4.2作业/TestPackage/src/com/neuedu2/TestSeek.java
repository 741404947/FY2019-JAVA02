package com.neuedu2;

import java.util.Scanner;

public class TestSeek {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a = {5,3,4,9,7,2,0,1,11,250};
		
		TestSeek ts = new TestSeek();
		ts.seek(a);
		
	}
	
	public void seek(int[] a) {
		int temp = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length-i-1; j++) {
				if(a[j] > a[j+1]) {
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "|");
		}
		System.out.println("");
		int x = 0;
		int y = a.length-1;
		int k = (x+y)/2;
		int n = 0;
		
		Scanner scan = new Scanner(System.in);
		System.out.print("请输入要查询的数字：");
		int m = scan.nextInt();
		
		while(x <= y) {
			n++;
			if(a[k] > m) {
				y = k-1;
			}else if(a[k] < m) {
				x = k+1;
			}else {
				System.out.println("已经查询到" + m + ";共进行了" + n + "次循环查找！！！");
				break;
			}
			k = (x+y)/2;
		}
		seek(a);
	}
		
}
