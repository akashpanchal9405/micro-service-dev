package com.inn.stringManipulation;

public class PanagramTest {

	public static void main(String[] args) {
		// IN GIVEN STRING A TO Z ALL CHARACTER SHOULT BE AVAILABLE OTHERWISE IT'S NOT A
		// PARANGRAM
		String input = "abcdefghijklmnopqrstuvwxyz";
		System.out.println("given string is panagram or not = " + isPanagram(input));
	}

	private static Boolean isPanagram(String input) {
		if (input.length() < 26) {
			return false;
		}
		for (char ch = 'a'; ch <= 'z'; ch++) {
			if (input.indexOf(ch) < 0)
				return false;
		}
		return true;
	}

}
