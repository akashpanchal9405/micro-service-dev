package com.inn.stringManipulation;

public class RerverseStringTest {

	public static void main(String[] args) {
		System.out.println(reverseStringJava7("madan"));
	}

	public static String reverseStringJava7(String input) {
		StringBuilder sb = new StringBuilder();
		for (int i = input.length() - 1; i >= 0; i--) {
			sb.append(input.charAt(i));
		}
		return sb.toString();
	}
	
}
