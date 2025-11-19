package com.inn.stringManipulation;

import java.util.stream.IntStream;

public class PalindromeTest {

	public static void main(String[] args) {
		// o/p of reverse string is same then string is palindrome using normal approach
		String input = "madam";
//		StringBuilder builder = new StringBuilder();
//		for (int i = input.length() - 1; i >= 0; i--) {
//			builder.append(input.charAt(i));
//		}
//		if (input.equals(builder.toString())) {
//			System.out.println("given string is palindrome = " + input);
//		} else {
//			System.out.println("string is not palindrome = " + input);
//		}

		// using java 8
		if (isPalindromeJava8(input)) {
			System.out.println("given string is palindrome = " + input);
		} else {
			System.out.println("string is not palindrome = " + input);
		}
	}

	public static boolean isPalindromeJava8(String input) {
		int backPointer = input.length() - 1;
		return IntStream.rangeClosed(0, backPointer)
				.allMatch(index -> input.charAt(index) == input.charAt(backPointer - index));
	}

}
