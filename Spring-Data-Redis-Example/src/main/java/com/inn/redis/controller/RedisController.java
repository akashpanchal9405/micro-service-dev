package com.inn.redis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inn.redis.entity.Product;
import com.inn.redis.repository.RedisRepository;

@RestController
@RequestMapping("/api/product")
public class RedisController {

	@Autowired
	private RedisRepository redisRepository;

	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return redisRepository.save(product);
	}

	@GetMapping("/{id}")
	@Cacheable(key = "#id", value = "Product", unless = "#result.price > 1000")
	public Product findProductById(@PathVariable Integer id) {
		return redisRepository.findProductById(id);
	}

	@GetMapping
	public List<Object> findAllProducts() {
		return redisRepository.findAllProducts();
	}

	@DeleteMapping("/{id}")
	@CacheEvict(key = "#id", value = "Product")
	public String deleteProductById(@PathVariable Integer id) {
		return redisRepository.deleteProduct(id);
	}
}
