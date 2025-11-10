package com.inn.user.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inn.user.advice.UserNotFoundException;
import com.inn.user.dto.UserDTO;
import com.inn.user.entity.User;
import com.inn.user.feign.HotelService;
import com.inn.user.feign.RatingService;
import com.inn.user.hotel.Hotel;
import com.inn.user.rating.Rating;
import com.inn.user.repository.UserRepository;
import com.inn.user.service.UserService;

//@Service
public class UserServiceImplFeignClient implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RatingService ratingService;

	@Autowired
	private HotelService hotelService;

	@Override
	public User addUser(UserDTO userDto) {
		User user = null;
		if (userDto != null) {
			user = new User();
			BeanUtils.copyProperties(userDto, user);
		}
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(Integer userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("User with given id not found on server:" + userId));
		List<Rating> ratingList = ratingService.getRatingsByUserId(userId);
		user.setRatings(ratingList);
		List<Rating> newRatingList = ratingList.stream().map(rating -> {
			Hotel hotel = hotelService.getHotelById(rating.getHotelId());
			if (hotel != null) {
				rating.setHotel(hotel);
				return rating;
			} else {
				return null;
			}
		}).filter(Objects::nonNull).collect(Collectors.toList());
		user.setRatings(newRatingList);
		return user;
	}

	@Override
	public String deleteUser(Integer userId) {
		Optional<User> userById = userRepository.findById(userId);
		if (userById.isPresent()) {
			userRepository.deleteById(userId);
		}

		return userRepository.findById(userId).isPresent() ? "user not deleted!!!"
				: "user with given id is deleted successfully:" + userId;
	}

	@Override
	public User updateUser(UserDTO userDto) {
		Optional<User> existingUser = userRepository.findById(userDto.getId());
		User updatedUser = null;
		if (existingUser.isPresent()) {
			User user = new User();
			BeanUtils.copyProperties(userDto, user);
			updatedUser = userRepository.save(user);
		}
		return updatedUser;
	}

}
