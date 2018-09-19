package com.test.exceptions;

public class ReThrowException {
	public static void main(String[] args) {
		try {
			System.out.println("Line 1");
			try {
				int i = 100 / 0;  //Throw Arithmetic Exception
				System.out.println("Line 2");
			} catch (Exception e) {
				System.out.println("Line 3");
				throw e;  //Re-Throw exception
			}
			System.out.println("Line 4");
		} catch (Exception e) {
			System.out.println("Line 5");
		}

	}
}

/*------output----
Line 1
Line 3
Line 4
--------------*/
