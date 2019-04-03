package com.neuedu2;


/**
 * @author 74140
 *线程死锁
 */
public class TestDealLock {
	
	 Object o1 = new Object();
	Object o2 = new Object();
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestDealLock tdl = new TestDealLock();
		
		
		Thread thread1 = new Thread(new MyRunnable1(),"t1");
		Thread thread2 = new Thread(new MyRunnable2(),"t2");

		thread1.start();
		thread2.start();
	}

}

class MyRunnable1 implements Runnable{

	private Object o1;
	private Object o2;
	
	public MyRunnable1() {
		this.o1 = o1;
		this.o2 = o2;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (o1) {
			System.out.println(Thread.currentThread().getName() + "已经锁住o1,还需要o2的锁。");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (o2) {
				System.out.println(Thread.currentThread().getName() + "已经锁住o2。");
			}
			
		}
		
	}
	
}

class MyRunnable2 implements Runnable{

	private Object o1;
	private Object o2;
	
	public MyRunnable2() {
		this.o1 = o1;
		this.o2 = o2;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (o2) {
			System.out.println(Thread.currentThread().getName() + "已经锁住o2,还需要o1的锁。");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (o1) {
				System.out.println(Thread.currentThread().getName() + "已经锁住o1。");
			}
			
		}
		
	}
	
}

