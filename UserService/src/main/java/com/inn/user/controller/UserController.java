package com.inn.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inn.user.dto.UserDTO;
import com.inn.user.entity.User;
import com.inn.user.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/addUser")
	public ResponseEntity<User> addUser(@RequestBody UserDTO userDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(userDTO));
	}

	@GetMapping(value = "/getUserById/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable Integer userId) {
		return ResponseEntity.ok(userService.getUser(userId));
	}

	@GetMapping(value = "/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.ok(userService.getAllUsers());
	}

	@DeleteMapping(value = "/deleteUser")
	public ResponseEntity<String> deleteUser(@RequestParam Integer userId) {
		return ResponseEntity.ok(userService.deleteUser(userId));
	}

	@PutMapping(value = "/updateUser")
	public ResponseEntity<User> updateUser(@RequestBody UserDTO userDTO) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(userDTO));
	}

}
