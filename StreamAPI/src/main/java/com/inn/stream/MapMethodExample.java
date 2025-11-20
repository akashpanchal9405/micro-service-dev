package com.inn.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapMethodExample {

	public static List<Customer> getCustomers() {
		return Stream
				.of(new Customer(12, "john", "john@gmail.com", Arrays.asList("889843934", "90384938")),
						new Customer(103, "smith", "smith@gmail.com", Arrays.asList("9904909393", "334833438")),
						new Customer(102, "peter", "peter@gmail.com", Arrays.asList("3434342989", "8983493834")),
						new Customer(43, "kelly", "kelly@gmail.com", Arrays.asList("839489385", "98938493804")))
				.collect(Collectors.toList());
	}

	public static void main(String[] args) {
		List<Customer> customerList = getCustomers();
		// i want to get all mail id list from customerList
		List<String> emailList = customerList.stream().map(cust -> cust.getEmail()).collect(Collectors.toList());
		System.out.println(emailList);

		// i want to get phone numbers list from customerList
		// so flatMap() will convert stream of stream elements into single stream
		List<String> phoneNumList = customerList.stream().flatMap(cust -> cust.getPhoneNumbers().stream())
				.collect(Collectors.toList());
		System.out.println(phoneNumList);
	}

}
