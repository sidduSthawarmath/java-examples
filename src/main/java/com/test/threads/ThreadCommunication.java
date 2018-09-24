package com.test.threads;

public class ThreadCommunication {

	private synchronized void method1() throws InterruptedException {
		System.out.println("Thread started running method1:" + Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getName()+" goes to waiting state");
		wait();  //object goes to waiting state
		System.out.println("Thread continued its exceution:" + Thread.currentThread().getName());
	}

	private synchronized void method2() throws InterruptedException {
		System.out.println("Thread started running method2:" + Thread.currentThread().getName());
		Thread.sleep(10000);
		System.out.println("Thread Completed its exceution:" + Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getName()+" called notify method");
		notifyAll(); //NotifyAll() or Notify() we need to call
	}

	public static void main(String[] args) {
		final ThreadCommunication threadCommunication1 = new ThreadCommunication();

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					threadCommunication1.method1();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}, "t1");

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					threadCommunication1.method2();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}, "t2");

		t1.start();
		t2.start();
	}

}
