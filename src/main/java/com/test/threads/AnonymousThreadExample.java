package com.test.threads;

public class AnonymousThreadExample {
	public static void main(String[] args) {

		new Thread() {
			@Override
			public void run() {
				System.out.println("In Thread anonymous class");
			}
		}.start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("In Runnable anonymous class");
			}
		}).start();
	}
}
