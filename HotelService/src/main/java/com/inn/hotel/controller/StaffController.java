package com.inn.hotel.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staffs")
public class StaffController {

	@GetMapping("/getAllStaffs")
	public ResponseEntity<List<String>> getAllStaffs() {
		List<String> staffList = Arrays.asList("Ram", "Gopal", "anand", "kailash");
		return new ResponseEntity<>(staffList, HttpStatus.OK);
	}

}
