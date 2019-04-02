package com.neuedu;

/**
 * @author 74140
 *线程同步
 */
public class TestSynchronized {
	public static void main(String[] args) {
		MyRunnable2 mr = new MyRunnable2();
		for (int i = 0; i < 2; i++) {
			Thread thread = new Thread(mr, "time:" + i);
			thread.start();
		}
	}
}
class MyRunnable2 implements Runnable {
	
	private int num;
		@Override
	public /*synchronized*/ void run() {//可以对方法进行上锁
		// TODO Auto-generated method stub
		synchronized (this) {//可以对要执行的具体方法体进行上锁
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "进行的是第" + num + "次的线程");	
		}
		num++;

	}
}