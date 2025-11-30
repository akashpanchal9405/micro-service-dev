package com.inn.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ListStreamLogical {

	public static void main(String[] args) {
		// find common elements from 2 list
		List<String> list1 = new ArrayList<>();
		list1.add("Apple");
		list1.add("Banana");
		list1.add("Orange");
		list1.add("Grape");

		List<String> list2 = new ArrayList<>();
		list2.add("Banana");
		list2.add("Kiwi");
		list2.add("Grape");
		list2.add("Mango");

//		findCommonElementsByStream(list1, list2);
		List<Integer> list3 = Arrays.asList(1, 2, 3, 4, 6, 7);
		List<Integer> list4 = Arrays.asList(4, 5, 7);
//		findDuplicateNumber(list3, list4);
		unionOfTwoList(list3, list4);
	}

	public static void unionOfTwoList(List<Integer> list1, List<Integer> list2) {
		Set<Integer> unionSet = new HashSet<>();
		unionSet.addAll(list1);
		unionSet.addAll(list2);
		System.out.println(unionSet);
	}

	public static void findCommonElements(List<String> list1, List<String> list2) {

		// Create a new list to store common elements
		List<String> commonElements = new ArrayList<>(list1);
		commonElements.retainAll(list2);
		System.out.println(commonElements);
	}

	public static void findCommonElementsByStream(List<String> list1, List<String> list2) {
		List<String> commonElements = list1.stream().filter(list2::contains).collect(Collectors.toList());
		System.out.println(commonElements);
	}

	public static void findDuplicateNumber(List<Integer> list1, List<Integer> list2) {
		list1.stream().filter(list2::contains).forEach(System.out::println);

	}
}
