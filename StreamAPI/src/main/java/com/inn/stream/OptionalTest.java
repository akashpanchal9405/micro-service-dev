package com.inn.stream;

import java.util.Arrays;
import java.util.Optional;

public class OptionalTest {

	public static void main(String[] args) {
		Customer customer = new Customer(1, "john", null, Arrays.asList("89483938"));

		// we can create Optional class object using 3 below methods
		// empty()
		Optional<Object> emptyOptional = Optional.empty();
		System.out.println(emptyOptional);

		// of() - if we're very sure about email is not null then only use of method, if
		// data is null we'll get NPE
		// because it will null check internally
//		Optional<String> emailOptional = Optional.of(customer.getEmail());//NPE
//		System.out.println(emailOptional); 

		// ofNullable() -> here if we're not sure about data is null or not then use
		// ofNullable()
		// because if internally uses ternary operator if data is null then return empty
		// Optional object,
		// if data is there then again if will call of() and this method null check
		// internally
		Optional<String> ofNullableEmail = Optional.ofNullable(customer.getEmail());
		if (ofNullableEmail.isPresent()) {
			System.out.println(ofNullableEmail.get());
		}

		// use else in optional in below line
		System.out.println(ofNullableEmail.orElse("dummy@gmail.com")); // if data is null then else block execute

		// orElseThrow
//		System.out.println(ofNullableEmail.orElseThrow(() -> new IllegalArgumentException("email Not present")));

		System.out.println(ofNullableEmail.map(String::toUpperCase).orElseGet(() -> "abc@gmail.com"));
	}

}
