package com.test.exceptions;

public class CustomCheckedException {
	public static void main(String[] args) throws BalanceException {
		int balance = -100;
		if (balance < 0) {
			
			// throwing checked exception(because BalanceException extends
			// Exception)
			// So we should handle using try/catch or we should use throws
	   		
			throw new BalanceException("Balance should not be in negative");
		}
	}
}

// This custom checked exception
class BalanceException extends Exception {
	public BalanceException(String msg) {
		super(msg);
	}
}
