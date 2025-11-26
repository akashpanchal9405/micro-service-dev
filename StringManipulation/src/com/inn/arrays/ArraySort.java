package com.inn.arrays;

import java.util.Arrays;

public class ArraySort {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 2, 1, 3, 4, 4, 2, 4, 5, 6, 5 };

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
				i = -1;
			}
		}
		System.out.println(Arrays.toString(arr));

	}

}
