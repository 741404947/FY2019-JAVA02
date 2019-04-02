package com.neuedu;

public class MyRunnable implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("======MyRunnable   run()====");
		for (int i = 0; i < 1000; i++) {
			//System.out.println("=====run=======" + i);
		/*	if(i%10 == 0) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println("whtwhtwthwht");
					e.printStackTrace();
					
				}
			}*/
			System.out.println("=====run=======" + i);
		}
	}

}
