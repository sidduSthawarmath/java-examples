package com.test.threads;

/*
 * In the below multithreaded program, thread t1 and t2 are concurrent
 * threads i.e they are executing their task simultaneously. There are
 * two Shared class objects, s1 and s2, which are shared by both the
 * threads. Shared class has two synchronized methods, methodOne() and
 * methodTwo(). That means, only one thread can execute these methods at
 * a given time.
 * 
 * First, thread t1 enters the methodOne() of s1 object by acquiring the
 * object lock of s1. At the same time, thread t2 also enters the
 * methodTwo() of s2 object by acquiring the object lock of s2.
 * methodOne() of s1 object, currently executing by thread t1, calls
 * methodTwo() of s2 object from it's body. So, thead t1 tries to
 * acquire the object lock of s2 object. But object lock of s2 object is
 * already acquired by thread t2. So, thread t1 waits for thread t2 to
 * release the object lock of s2 object.
 * 
 * At the same time, thread t2 is also executing methodTwo() of s2
 * object. methodTwo() of s2 object also makes a call to methodOne() of
 * s1 object. So, thread t2 tries to acquire the object lock of s1
 * object. But, it is already acquired by thread t1. So, thread t2 also
 * waits for thread t1 to release the object lock of s1 object.
 * 
 * Thus, both the threads wait for each other to release the object
 * locks they own. They wait for infinite period of time to get the
 * object locks owned by opposite threads. This condition of threads
 * waiting forever is called Deadlock.
 */

class Shared {

	synchronized void methodOne(Shared s) {
		Thread t = Thread.currentThread();
		System.out.println(t.getName() + "is executing methodOne...");
		System.out.println(t.getName() + "is calling methodTwo...");
		s.methodTwo(this);
		System.out.println(t.getName() + "is finished executing methodOne...");
	}

	synchronized void methodTwo(Shared s) {
		Thread t = Thread.currentThread();
		System.out.println(t.getName() + "is executing methodTwo...");
		System.out.println(t.getName() + "is calling methodOne...");
		s.methodOne(this);
		System.out.println(t.getName() + "is finished executing methodTwo...");
	}
}

public class DeadLockInJava {
	public static void main(String[] args) {
		final Shared s1 = new Shared();
		final Shared s2 = new Shared();

		Thread t1 = new Thread() {
			public void run() {
				s1.methodOne(s2);
			}
		};

		Thread t2 = new Thread() {
			@Override
			public void run() {
				s2.methodTwo(s1);
			}
		};

		t1.start();
		t2.start();
		
	}
}