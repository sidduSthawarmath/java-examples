package com.test.threads;

public class InnerClassThread {

	class TestThread implements Runnable {
		@Override
		public void run() {
			System.out.println("Running thread name:" + Thread.currentThread().getName());
		}
	}

	public static void main(String[] args) {
		new Thread(new InnerClassThread().new TestThread(), "TestThread").start();
	}

}
