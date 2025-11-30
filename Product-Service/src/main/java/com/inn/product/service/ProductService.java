package com.inn.product.service;

import java.util.List;

import com.inn.product.dto.ProductRequest;
import com.inn.product.dto.ProductResponse;

public interface ProductService {

	public void createProduct(ProductRequest productRequest);

	public List<ProductResponse> getAllProducts();

}
