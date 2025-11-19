package com.inn.stringManipulation;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnagramTest {

	public static void main(String[] args) {
//		System.out.println("given is anaragram or not = " + isAnagramJava7("pawan", "wapan"));
//		List<String> words = Arrays.asList("listen", "silent", "enlist", "rat", "tar", "god", "dog");
//		isAnagramListJava8(words);
		isAnagramStringsJava8("team", "meat");
	}

	private static void isAnagramStringsJava8(String input1, String input2) {

		String anagram1 = Stream.of(input1.split("")).map(s -> s.toLowerCase()).sorted().collect(Collectors.joining());

		String anagram2 = Stream.of(input2.split("")).map(s -> s.toLowerCase()).sorted().collect(Collectors.joining());

		if (anagram1.equals(anagram2))
			System.out.println("given stringa are anagram");
		else
			System.out.println("strings are not anagram");
	}

	private static void isAnagramListJava8(List<String> words) {

		Map<String, List<String>> groupedAnagrams = words.stream().collect(Collectors.groupingBy(word -> {
			char[] chars = word.toCharArray();
			Arrays.sort(chars);
			return new String(chars);
		}));

		List<List<String>> anagramPairs = groupedAnagrams.values().stream().filter(group -> group.size() > 1)
				.collect(Collectors.toList());

		System.out.println("Anagram Pairs: " + anagramPairs);
	}

	public static Boolean isAnagramJava7(String s1, String s2) {
		if (s1.length() != s2.length()) {
			throw new RuntimeException("given string length is not equal");
		}

		char[] ch1 = s1.toCharArray();
		char[] ch2 = s2.toCharArray();
		Arrays.sort(ch1);
		Arrays.sort(ch2);

		return Arrays.equals(ch1, ch2);
	}

}
