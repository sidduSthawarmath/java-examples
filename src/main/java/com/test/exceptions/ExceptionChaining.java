package com.test.exceptions;

/*
 * Basically, exception chaining is the process of re-throwing multiple
 * exceptions across different abstraction layers of a program. The key
 * principle here is that, these exceptions are chained together to maintain
 * the stack trace from the exception at the lowest layer to the one at the
 * highest layer
 */

public class ExceptionChaining {

	public static void main(String[] args) {
		try {
			// creating an exception
			NumberFormatException ex = new NumberFormatException("Exception");

			// setting a cause of the exception
			ex.initCause(new NullPointerException("This is actual cause of the exception"));

			throw ex;
		} catch (NumberFormatException ex) {
			// displaying the exception
			System.out.println(ex);

			// getting the actual cause of the exception
			System.out.println(ex.getCause());
		}
	}
}
