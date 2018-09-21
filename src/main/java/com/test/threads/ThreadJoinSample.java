package com.test.threads;

public class ThreadJoinSample {

	public static void main(String[] args) {

		final Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 1; i <= 100; i++) {
					System.out.print(i + " ");
				}
			}
		});

		final Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					t1.join();
					System.out.println("");
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}

				for (int i = 101; i <= 200; i++) {
					System.out.print(i + " ");
				}
			}
		});

		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					t2.join();
					System.out.println("");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				for (int i = 201; i <= 300; i++) {
					System.out.print(i + " ");
				}
			}
		});

		t1.start();
		t2.start();
		t3.start();
	}
}
