package com.test.threads;

public class ThreadExample implements Runnable{

	@Override
	public void run() {
		System.out.println("In Run method");
	}

	public static void main(String[] args) {
		ThreadExample threadExample=new ThreadExample();
		Thread t1=new Thread(threadExample);
		t1.start();
	}
}
