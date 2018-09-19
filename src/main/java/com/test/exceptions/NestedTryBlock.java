package com.test.exceptions;

public class NestedTryBlock {
	public static void main(String[] args) {
		try {
			Integer i = new Integer("100");
			try {
				String name = null;
				System.out.println(name.equals("sidddu"));
			} catch (NullPointerException e) {
				e.printStackTrace();
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
}
