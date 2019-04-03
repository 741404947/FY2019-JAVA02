package com.neuedu;

public class TestThread extends Thread{

	//private Runnable r;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
/*		//创建线程
		Thread thread = new TestThread();
		//启动子线程
		thread.start();*/
		
		
		//实现（继承）接口的构造方法
		Runnable r = new MyRunnable();
		//对线程的构造方法
		Thread t = new Thread(r, "什么东西");
		//启动子线程
		t.start();
		
		
		System.out.println(t.getPriority());
		t.setPriority(MAX_PRIORITY);
		System.out.println(t.getId());
		System.out.println(t.getName());
		System.out.println(t.getState());
		//主线程的
		for (int i = 0; i < 100; i++) {
			/*if(i%10 == 0) {
				t.yield();
			}*/
			System.out.println("======main======" + i);
		}
		
		
		
	}



	
	public TestThread() {
		
	}
	
	/*//子线程
	public void run() {
		for (int i = 0; i < 1000; i++) {
			//System.out.println("=====run=======" + i);
			if(i%10 == 0) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println("whtwhtwthwht");
					e.printStackTrace();
					
				}
			}else {
				System.out.println("=====run=======" + i);
			}
		}
	}
	*/
	
	
/*	public void run_two() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("=====run_two=======" + i);
		}
	}*/

}
