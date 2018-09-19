package com.test.exceptions;

public class CustomException {

	public static void main(String[] args) throws BalanceException {
		int balance = -100;
		if (balance < 0) {
			throw new BalanceException("Balance should not be in negative");  //Throw custom exception
		}
	}
}


//This custom exception
class BalanceException extends Exception {
	public BalanceException(String msg) {
		super(msg);
	}
}
