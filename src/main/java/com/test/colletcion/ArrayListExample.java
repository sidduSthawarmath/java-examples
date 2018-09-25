package com.test.colletcion;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

	public static void main(String[] args) {

		List<String> numList = new ArrayList<>();
		numList.add("ONE"); // Add element to list
		numList.add("TWO");
		numList.add("THREE");
		numList.add("FOUR");
		System.out.println("List after adding the elements:\n" + numList);

		// Removes the elements from 2 index(index start with 0 so third element
		// get removed)
		numList.remove(2);
		System.out.println("\nList after removing 2nd index:\n" + numList);

		// Removes the elements from by object
		numList.remove("ONE");
		System.out.println("\nRemoves the elements from by object:\n" + numList);

		// Add the elements from by object and index
		numList.add(0, "ONE");
		System.out.println("\nAdd the elements from by object and index:\n" + numList);

		// Add the elements from by object
		numList.add("FOUR");
		System.out.println("\nAdd the elements from by object :\n" + numList);

		// Replace the elements from by object
		numList.set(3,"FIVE");
		System.out.println("\nAdd the elements from by object :\n" + numList);

	}
}
