package com.inn.user.service;

import java.util.List;

import com.inn.user.dto.UserDTO;
import com.inn.user.entity.User;

public interface UserService {

	public User addUser(UserDTO userDto);

	public List<User> getAllUsers();

	public User getUser(Integer userId);

	public String deleteUser(Integer userId);

	public User updateUser(UserDTO userDto);

}
