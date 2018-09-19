package com.test.exceptions;

/*
 * From Java 7 onward, there is one more way for handling multiple
 * exceptions. Multiple exceptions thrown by the try block can be handled by
 * a single catch block using pipe (|) operator. By using pipe operator
 */
public class PipeOperator {
	public static void main(String[] args) {
		try {
			int i = 100 / 0;
		} catch (NullPointerException | ArithmeticException e) { // This is multiple catch using | 
			e.printStackTrace();
		}
	}
}
