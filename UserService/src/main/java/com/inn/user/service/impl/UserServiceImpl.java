package com.inn.user.service.impl;

import java.util.ArrayList;
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

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RatingService ratingService;

	@Autowired
	private HotelService hotelService;

//	@Autowired
//	private RestTemplate restTemplate;

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
		List<User> existingUserList = userRepository.findAll();
		List<User> newUserList = new ArrayList<>();
		for (User user : existingUserList) {
			// approach 1
//			String url = "http://RATING-SERVICE/rating/getRatingByUserId/" + user.getUserId();
//			log.info("going to fetch data from rating service with url:{}", url);
//			Rating[] ratingArray = restTemplate.getForObject(url, Rating[].class);
//			List<Rating> ratingsList = Arrays.stream(ratingArray).toList();
//			log.info("get data from ratings service using restTemplate :{}", ratingsList);

			// approach 2
			List<Rating> ratingsList = ratingService.getRatingsByUserId(user.getUserId());
			List<Rating> newRatingList = ratingsList.stream().map(rating -> {
				// approach 1
//				String hotelUrl = "http://HOTEL-SERVICE/hotels/getHotelById/" + rating.getHotelId();
//				ResponseEntity<Hotel> hotel = restTemplate.getForEntity(hotelUrl, Hotel.class);
				Hotel hotel = hotelService.getHotelById(rating.getHotelId());
				if (hotel != null) {
					rating.setHotel(hotel);
					return rating;
				} else {
					return null;
				}
			}).filter(Objects::nonNull).collect(Collectors.toList());
			log.info("get data from ratings service using restTemplate :{}", ratingsList);
			if (newRatingList != null && !newRatingList.isEmpty()) {
				user.setRatings(ratingsList);
				newUserList.add(user);
			}
			log.info("newUserList data:{}", newUserList.toString());
		}
		return newUserList != null && !newUserList.isEmpty() ? newUserList : existingUserList;
	}

	int retryCount = 1;

	@SuppressWarnings("unchecked")
	@Override
//	@CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallBack")
	@Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelFallBack")
	public User getUser(Integer userId) {
		//to check retry is working 
		log.info("retry count =" + retryCount);
		retryCount++;
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("User with given id not found on server:" + userId));
		user.setRatings(getRatingList(userId));
		return user;
	}

	public User ratingHotelFallBack(Integer userId, Exception ex) {
		log.info("Fallback executed because service is down: " + ex.getMessage());
		return User.builder().about("this is dummy user").email("dummy@gmail.com").name("dummy").build();
	}

	private List<Rating> getRatingList(Integer userId) {
		// approach 1
//		String url = "http://RATING-SERVICE/rating/getRatingByUserId/" + userId;
//		Rating[] ratingsArray = restTemplate.getForObject(url, Rating[].class);
//		List<Rating> ratingsList = Arrays.stream(ratingsArray).toList();

		// approach 2
		List<Rating> ratingsList = ratingService.getRatingsByUserId(userId);

		List<Rating> newRatingList = ratingsList.stream().map(rating -> {
			// approach 1
//			String hotelUrl = "http://HOTEL-SERVICE/hotels/getHotelById/" + rating.getHotelId();
//			ResponseEntity<Hotel> hotel = restTemplate.getForEntity(hotelUrl, Hotel.class);
			log.info("log before hotel service call:{}", rating.getHotelId());
			// approach 2
			Hotel hotel = hotelService.getHotelById(rating.getHotelId());
			if (hotel != null) {
				rating.setHotel(hotel);
				return rating;
			} else {
				return null;
			}
		}).filter(Objects::nonNull).collect(Collectors.toList());

		return newRatingList;
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
