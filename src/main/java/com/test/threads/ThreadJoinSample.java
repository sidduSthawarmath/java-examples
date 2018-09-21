package com.test.threads;

/*
 * join() method of java.lang.Thread class is used to maintain the order of
 * execution of threads. Using join() method, you can make the currently
 * executing thread to wait for the some other threads to finish their task.
 * For example, Let's us assume that there are two threads namely, thread1
 * and thread2. You can make thread2 to hold it's execution for some time so
 * that thread1 can finish it's task. After, thread1 finishes it's task,
 * thread2 resumes it's execution.For this to happen, you should call join()
 * method on thread1 within thread2.
 */   

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
					t1.join();    //Holding t2 thread execution until finish t1 execution
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
					t2.join(); //Holding t3 thread execution until finish t2 execution
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
