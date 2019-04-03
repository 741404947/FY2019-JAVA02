package com.neuedu;

/**
 * @author 74140
 *�߳�ͬ��
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
	public /*synchronized*/ void run() {//���ԶԷ�����������
		// TODO Auto-generated method stub
		synchronized (this) {//���Զ�Ҫִ�еľ��巽�����������
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "���е��ǵ�" + num + "�ε��߳�");	
		}
		num++;

	}
}