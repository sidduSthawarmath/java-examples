package com.test.exceptions;

/*
 * If method has return type then 
 * 
 * 1.If finally block returns a value
 * then try and catch blocks may or may not return a value 
 * 
 * 2.If finally
 * block does not return a value then both try and catch blocks must
 * return a value.
 */

public class ReturnValue {
	public static void main(String[] args) {
		int val = retunValue();
		System.out.println("Value:" + val);
	}

	private static int retunValue() {
		try {
			int i = 100 / 0;
			System.out.println("In try block");
			return 1; // It should return
		} catch (Exception e) {
			System.out.println("In catch block");
			return 2; // It should return
		} finally {
			System.out.println("In finally block");
			// return 3; //We don't have return in finally so try and catch both
			// are returning value

		}

	}
}
