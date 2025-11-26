package com.inn.stringManipulation;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringFrequency {

	public static void main(String[] args) {

		String input = "asjfkjdfaijfg";

		firstNonRepeatingChar(input);
		frequncyOfString(input);

	}

	public static void firstNonRepeatingChar(String input) {
		LinkedHashMap<String, Long> linkedHashMap = Arrays.stream(input.split(""))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

		Optional<String> firstNonRepeatingChar = linkedHashMap.entrySet().stream()
				.filter(entry -> entry.getValue() == 1).map(entry -> entry.getKey()).findFirst();

		System.out.println(firstNonRepeatingChar);
	}

	public static void frequncyOfString(String input) {
		IntStream stream = input.chars();
		Map<Character, Long> frequencyOfString = stream.mapToObj(ch -> (char) ch)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		System.out.println(frequencyOfString);
	}

}
