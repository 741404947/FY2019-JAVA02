package com.neuedu;

public class TestThread extends Thread{

	//private Runnable r;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
/*		//�����߳�
		Thread thread = new TestThread();
		//�������߳�
		thread.start();*/
		
		
		//ʵ�֣��̳У��ӿڵĹ��췽��
		Runnable r = new MyRunnable();
		//���̵߳Ĺ��췽��
		Thread t = new Thread(r, "ʲô����");
		//�������߳�
		t.start();
		
		
		System.out.println(t.getPriority());
		t.setPriority(MAX_PRIORITY);
		System.out.println(t.getId());
		System.out.println(t.getName());
		System.out.println(t.getState());
		//���̵߳�
		for (int i = 0; i < 100; i++) {
			/*if(i%10 == 0) {
				t.yield();
			}*/
			System.out.println("======main======" + i);
		}
		
		
		
	}



	
	public TestThread() {
		
	}
	
	/*//���߳�
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
