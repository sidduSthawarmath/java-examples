package com.test.threads;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

class Shared1 {

	synchronized void methodOne(Shared1 s) {
		Thread t = Thread.currentThread();
		System.out.println(t.getName() + "is executing methodOne...");
		System.out.println(t.getName() + "is calling methodTwo...");
		s.methodTwo(this);
		System.out.println(t.getName() + "is finished executing methodOne...");
	}

	synchronized void methodTwo(Shared1 s) {
		Thread t = Thread.currentThread();
		System.out.println(t.getName() + "is executing methodTwo...");
		System.out.println(t.getName() + "is calling methodOne...");
		s.methodOne(this);
		System.out.println(t.getName() + "is finished executing methodTwo...");
	}
}

public class DeadLockDetectInJava {
	public static void main(String[] args) {
		final Shared1 s1 = new Shared1();
		final Shared1 s2 = new Shared1();

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
		
		
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();

        long ids[] = bean.findMonitorDeadlockedThreads();

        if(ids != null)
        {
                ThreadInfo threadInfo[] = bean.getThreadInfo(ids);

                for (ThreadInfo threadInfo1 : threadInfo)
                {
                        System.out.println("ID of deadlocked thread:"+threadInfo1.getThreadId());    //Prints the ID of deadlocked thread

                        System.out.println("the name of deadlocked thread:"+threadInfo1.getThreadName());  //Prints the name of deadlocked thread

                        System.out.println("the string representation of an object for which thread has entered into deadlock.:"+threadInfo1.getLockName());    //Prints the string representation of an object for which thread has entered into deadlock.

                        System.out.println("the ID of thread which currently owns the object lock:"+threadInfo1.getLockOwnerId());  //Prints the ID of thread which currently owns the object lock

                        System.out.println("name of the thread which currently owns the object lock:"+threadInfo1.getLockOwnerName());  //Prints name of the thread which currently owns the object lock.
                }
        }
        else
        {
                System.out.println("No Deadlocked Threads");
        }
}
}

