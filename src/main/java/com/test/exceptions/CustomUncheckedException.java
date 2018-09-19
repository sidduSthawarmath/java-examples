package com.test.exceptions;

public class CustomUncheckedException {
	public static void main(String[] args) {
		int balance = -100;
		if (balance < 0) {

			// throwing checked exception(because BalanceException extends
			// Exception)
			// So we should handle using try/catch or we should use throws

			throw new BalanceCheckException("Balance should not be in negative");
		}
	}
}

// This custom checked exception
class BalanceCheckException extends RuntimeException {
	public BalanceCheckException(String msg) {
		super(msg);
	}
}
