package com.inn.hotel.entity;

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
@Table(name = "HOTELS")
public class Hotel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "HOTEL_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer hotelId;

	@Column(name = "HOTEL_NAME")
	private String hotelName;

	@Column(name = "LOCATION")
	private String location;

	@Column(name = "ABOUT")
	private String about;
}
