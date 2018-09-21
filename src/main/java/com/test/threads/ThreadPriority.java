package com.test.threads;

public class ThreadPriority {
	class TestThread implements Runnable {
		@Override
		public void run() {
			System.out.println("In run method");
		}
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new ThreadPriority().new TestThread());
		t1.setPriority(4);
		t1.start();
	}

}
