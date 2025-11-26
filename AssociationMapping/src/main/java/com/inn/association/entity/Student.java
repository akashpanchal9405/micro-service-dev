package com.inn.association.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer studId;

	private String studName;

	private String rollNumber;

	// here one student has one laptop
	// oneToOne mapping example

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "lapId")
	private Laptop laptop;

	// here one student has multiple address
	// oneToMany example

	@OneToMany(mappedBy = "addId", cascade = CascadeType.ALL)
	private List<Address> addressList = new ArrayList();

}
