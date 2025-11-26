package com.inn.merchant.product;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inn.merchant.Product;
import com.inn.merchant.exceptions.ProductNotFoundException;
import com.inn.merchant.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product addProductDetails(Product product) {
		log.info("inside product service addProductDetails product:{}", product);
		Product savedProduct = null;
		if (product != null) {
			savedProduct = productRepository.save(product);
			log.info("saved product:{}", savedProduct);
		}
		return savedProduct;
	}

	@Override
	public Product getProductDetails(Integer productId) {
		log.info("inside product service getProductDetails productId");
		Optional<Product> dbRecord = null;
		Product product = null;
		if (productId != null) {
			dbRecord = Optional.ofNullable(
					productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException(productId)));
		}
		return dbRecord.isPresent() ? dbRecord.get() : product;

	}

}
