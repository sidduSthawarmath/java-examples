package com.test.threads;

public class SampleThread extends Thread {

	@Override
	public void run() {
		System.out.println("It in run method");
	}
	
	public static void main(String[] args) {
		SampleThread sampleThread = new SampleThread();
		Thread thread = new Thread(sampleThread, "SampleThread");
		thread.start();
	}
}
