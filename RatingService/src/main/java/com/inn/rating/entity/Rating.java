package com.inn.rating.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "RATINGS")
public class Rating implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "RATING_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer ratingId;

	@Column(name = "USER_ID")
	private Integer userId;

	@Column(name = "HOTEL_ID")
	private Integer hotelId;

	@Column(name = "RATING")
	private Integer rating;

	@Column(name = "FEEDBACK")
	private String feedback;

}
