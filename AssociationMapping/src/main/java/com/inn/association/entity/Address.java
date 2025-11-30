package com.inn.association.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addId;

	private String cityName;

	private Integer pinCode;

	private String state;

	private String country;

	@ManyToOne
	@JoinColumn(name = "studId")
	@JsonBackReference
	private Student student;
}
