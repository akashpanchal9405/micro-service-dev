package com.inn.arrays;

import java.util.Arrays;

public class ArrayFrequencyCount {

	public static void main(String[] args) {
		int[] integerArr = { 1, 2, 3, 2, 1, 3, 4, 4, 2, 4, 5, 6, 5 };

		countOfOrrcurance(integerArr);
	}

	private static void countOfOrrcurance(int[] arr) {
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			int count = 1;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					count++;
				} else
					break;
			}
			System.out.println(arr[i] + " => " + count);
			i += count - 1;
		}
	}

}
