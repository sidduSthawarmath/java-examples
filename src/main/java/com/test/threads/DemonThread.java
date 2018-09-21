package com.test.threads;

public class DemonThread implements Runnable {

	@Override
	public void run() {
		System.out.println("in Run method");
	}

	public static void main(String[] args) {
		Thread t = new Thread(new DemonThread());
		// Set Daemon thread, JVM will not wait until finish daemon thread
		// execution. setDaemon flag has to set before start() method otherwise
		// will get
		// exception IllegalThreadStateException
		t.setDaemon(true);
		t.start();
	}

}
