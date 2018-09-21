package com.test.threads;

public class SynchronizedExample {

	// Blocked complete method
	public synchronized void sharedMethod() {
		System.out.println("\nShared Method\n----------\nThread Name:" + Thread.currentThread().getName());
		for (int i = 1; i <= 10; i++) {
			System.out.print(i);
		}
	}

	public void sharedInstanceBlockOfCode() {
		synchronized (this) {
			System.out.println("\nShared Instance\n----------\nThread Name:" + Thread.currentThread().getName());
			int i = 10;
			System.out.println(Thread.currentThread().getName() + "\t i=" + i);

			i = 20;
			System.out.println(Thread.currentThread().getName() + "\t i=" + i);

			i = 30;
			System.out.println(Thread.currentThread().getName() + "\t i=" + i);
		}
	}

	public static void sharedStaticBlockOfCode() {
		synchronized (SynchronizedExample.class) {
			System.out.println("\nShared Static\n----------\nThread Name:" + Thread.currentThread().getName());
			int i = 10;
			System.out.println(Thread.currentThread().getName() + "\t i=" + i);

			i = 20;
			System.out.println(Thread.currentThread().getName() + "\t i=" + i);

			i = 30;
			System.out.println(Thread.currentThread().getName() + "\t i=" + i);
		}
	}

	public static void main(String[] args) {
		final SynchronizedExample synchronizedExample = new SynchronizedExample();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				synchronizedExample.sharedMethod();
				synchronizedExample.sharedInstanceBlockOfCode();
				sharedStaticBlockOfCode();
			}
		}, "t1");

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				synchronizedExample.sharedMethod();
				synchronizedExample.sharedInstanceBlockOfCode();
				sharedStaticBlockOfCode();
			}
		}, "t2");

		t1.start();
		t2.start();

	}

}
