package com.inn.merchant.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Merchant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "merchant_id")
	private Integer merchantId;

	@Column
	@NotBlank(message = "name is mandatory")
	private String name;

	@Column
	@NotBlank(message = "address is mandatory")
	private String address;

	@Column
	@NotBlank(message = "phone is mandatory")
	private String phone;

	@Column
	@Email(message = "Email should be valid")
	@NotBlank(message = "email is mandatory")
	private String email;

}
