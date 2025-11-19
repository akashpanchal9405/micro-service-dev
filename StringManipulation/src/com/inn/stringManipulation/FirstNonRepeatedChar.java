package com.inn.stringManipulation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatedChar {

	public static void main(String[] args) {
//		firstNonRepeatedCharacter("manjunatham");
		firstNonRepeatJava8("jumanji");
	}

	public static void firstNonRepeatedCharacter(String input) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (map.get(ch) == null) {
				map.put(ch, 1);
			} else {
				map.put(ch, map.get(ch) + 1);
			}
		}

		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (map.get(ch) == 1) {
				System.out.println("first non repeating character from given string is =" + ch);
				break;
			}
		}

	}

	public static void firstNonRepeatJava8(String input) {
		LinkedHashMap<String, Long> map = Arrays.stream(input.split(""))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		System.out.println("first non repeatedChar = " + map.entrySet().stream().filter(num -> num.getValue() == 1)
				.map(num -> num.getKey()).findFirst().get());
	}

}
