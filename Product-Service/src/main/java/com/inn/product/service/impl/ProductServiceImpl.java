package com.inn.product.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inn.product.dto.ProductRequest;
import com.inn.product.dto.ProductResponse;
import com.inn.product.entity.Product;
import com.inn.product.repository.ProductRepository;
import com.inn.product.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	@Override
	public void createProduct(ProductRequest productRequest) {
		Product product = Product.builder().name(productRequest.getName()).description(productRequest.getDescription())
				.price(productRequest.getPrice()).build();
		productRepository.save(product);
		log.info("product : {} is saved", product.getId());
	}

	@Override
	public List<ProductResponse> getAllProducts() {
		List<Product> productList = productRepository.findAll();
		return productList.stream().map(product -> mapProductToProductResponse(product)).toList();
	}

	private ProductResponse mapProductToProductResponse(Product product) {
		return ProductResponse.builder().id(product.getId()).name(product.getName())
				.description(product.getDescription()).price(product.getPrice()).build();
	}

}
