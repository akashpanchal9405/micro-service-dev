package com.inn.redis.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String name;

	private Integer quantity;

	private Long price;

}
