package com.test.exceptions;

public class NestedTryBlock {
	public static void main(String[] args) {
		try {
			Integer i = new Integer("100"); //chance of NumberFormatException
			try {     //This is nested try block                 
				String name = null;
				System.out.println(name.equals("sidddu"));  //NullPointerException
			} catch (NullPointerException e) {
				e.printStackTrace();
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
}
