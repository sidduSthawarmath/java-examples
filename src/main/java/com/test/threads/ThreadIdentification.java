package com.test.threads;

public class ThreadIdentification {

	class TestThread implements Runnable {
		@Override
		public void run() {
			System.out.println("In run() method");
		}
	}

	public static void main(String[] args) {
		TestThread testThread = new ThreadIdentification().new TestThread();
		Thread t1 = new Thread(testThread);
		
		t1.setName("sample-thread-1"); //Initial name set
		System.out.println("sample-thread-1 thread name id:" + Thread.currentThread().getId()); // output : 10 
	
		t1.setName("sample-thread-2"); //Thread name got changed
		System.out.println("sample-thread-2 thread name id:" + Thread.currentThread().getId()); // output : 10
		
		//Thread id remain same its life span even though thread name got changed
		t1.start();

		
		
	}

}
