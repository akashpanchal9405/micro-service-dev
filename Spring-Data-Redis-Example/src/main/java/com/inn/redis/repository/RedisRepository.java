package com.inn.redis.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.inn.redis.entity.Product;

@Repository
public class RedisRepository {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	private static final String HASH_KEY = "Product";

	public Product save(Product product) {
		redisTemplate.opsForHash().put(HASH_KEY, product.getId(), product);
		return product;
	}

	public List<Object> findAllProducts() {
		return redisTemplate.opsForHash().values(HASH_KEY);
	}

	public Product findProductById(Integer id) {
		System.out.println("fetch record from database...");
		return (Product) redisTemplate.opsForHash().get(HASH_KEY, id);
	}

	public String deleteProduct(Integer id) {
		redisTemplate.opsForHash().delete(HASH_KEY, id);
		return "product removed!";
	}
}
