package com.inn.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.OptionalInt;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ArrayLogicalQuestions {

	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3, 5 };
//		System.out.println("The missing value in the array is: " + findMissingNumber(numbers, 7));

		// --------------------
		String[] originalArray = { "apple", "banana", "orange", "apple", "grape", "banana" };

//		String[] uniqueArray = removeDuplicatesUsingHashSet(originalArray);
//		System.out.println("Original Array: " + Arrays.toString(originalArray));
//		System.out.println("Array with Duplicates Removed (using HashSet): " + Arrays.toString(uniqueArray));
//		System.out.println(removeDuplicateStringByStreams(originalArray));

//		findDuplicateString();
		String s1 = "listen";
        String s2 = "silent";
        String s3 = "hello";
        String s4 = "world";

//        System.out.println(s1 + " and " + s2 + " are anagrams: " + areAnagrams(s1, s2)); // true
//        System.out.println(s3 + " and " + s4 + " are anagrams: " + areAnagrams(s3, s4)); // false
//        System.out.println("Race and Care are anagrams: " + areAnagrams("Race", "Care")); // true
        
//        String text = "Ram is employee of ABC company, ram is from Blore, RAM! is good in algorithms.";
//	    List<String> wordsList = Arrays.asList(text.split("[^a-zA-Z0-9]+"));
//	    System.out.println(wordsList);
		
	}

	public static boolean areAnagrams(String str1, String str2) {
        // Handle null or empty strings
        if (str1 == null || str2 == null) {
            return false;
        }
        if (str1.isEmpty() && str2.isEmpty()) {
            return true;
        }

        // Normalize and sort characters using streams
        String sortedStr1 = str1.toLowerCase().chars()
                                .sorted()
                                .mapToObj(c -> String.valueOf((char) c))
                                .collect(Collectors.joining());

        String sortedStr2 = str2.toLowerCase().chars()
                                .sorted()
                                .mapToObj(c -> String.valueOf((char) c))
                                .collect(Collectors.joining());

        // Compare the sorted strings
        return sortedStr1.equals(sortedStr2);
    }
	
	public static void findDuplicateString() {
		List<String> names = new ArrayList<>();
		names.add("Alice");
		names.add("Bob");
		names.add("Alice");
		names.add("Charlie");
		names.add("Bob");

		Set<String> seen = new HashSet<>();
		Set<String> duplicates = names.stream().filter(name -> !seen.add(name)) // If add returns false, it's a
																				// duplicate
				.collect(Collectors.toSet());

		System.out.println("Duplicate names: " + duplicates);
	}

	public static void findDuplicatesUsingHashSet() {
		List<String> names = new ArrayList<>();
		names.add("Alice");
		names.add("Bob");
		names.add("Alice");
		names.add("Charlie");
		names.add("Bob");
		Set<String> seen = new HashSet<>();
		Set<String> duplicates = new HashSet<>();
		for (String item : names) {
			if (!seen.add(item)) { // If add() returns false, it's a duplicate
				duplicates.add(item);
			}
		}
	}

	public static String[] removeDuplicatesUsingHashSet(String[] array) {
		Set<String> uniqueElements = new TreeSet<>(Arrays.asList(array));
		return uniqueElements.toArray(new String[0]);

	}

	public static List<String> removeDuplicateStringByStreams(String[] originalList) {
		List<String> distinctList = Arrays.asList(originalList).stream().distinct().collect(Collectors.toList());
		return distinctList;
	}

	public static int findMaximumNumberByStream() {
		int[] numbers = { 12, 5, 34, 1, 10, 28 };
		OptionalInt max = Arrays.stream(numbers).max();
		return max.getAsInt();
	}

	public static int findMaximumNumber() {
		int[] numbers = { 12, 5, 34, 1, 10, 28 };
		int max = numbers[0]; // Initialize max with the first element

		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] > max) {
				max = numbers[i]; // Update max if a larger element is found
			}
		}
		return max;
	}

	public static int findMissingNumber(int[] arr, int n) {
		// n is the total count of numbers if none were missing
		// For example, if array has [1, 2, 4, 5] and n = 5 (meaning numbers from 1 to
		// 5)

		// Calculate the expected sum of numbers from 1 to n
		long expectedSum = (long) n * (n + 1) / 2;
		System.out.println("expectedSum =" + expectedSum);

		// Calculate the actual sum of elements in the given array
		long actualSum = 0;
		for (int num : arr) {
			actualSum += num;
		}
		System.out.println("actualSum =" + actualSum);

		// The missing number is the difference
		return (int) (expectedSum - actualSum);
	}

	public static int findMissingNumberByStreams() {
		int[] numbers = { 1, 2, 3, 4 };
		int num = numbers.length + 1;
		int expectedSum = num * (num + 1) / 2;
		int actualSum = Arrays.stream(numbers).sum();

		return (expectedSum - actualSum);
	}
}
