package com.inn.transaction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.inn.transaction.entity.Product;
import com.inn.transaction.repository.InventoryRepository;
import com.inn.transaction.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryRepository productRepository;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Product updateProductDetails(Product product) {
		// forcefully throwing exception and check db tables with
		// wrong entries without transaction and with transaction
		if (product.getPrice() > 5000) {
			throw new RuntimeException("DB crashed!!!");
		}
		return productRepository.save(product);
	}

	@Override
	public Product getProductById(Integer productId) {
		return productRepository.findById(productId)
				.orElseThrow(() -> new RuntimeException("product not found by given id"));
	}

}
