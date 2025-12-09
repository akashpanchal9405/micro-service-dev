package com.inn.transaction.service;

import com.inn.transaction.entity.Product;

public interface InventoryService {

	public Product updateProductDetails(Product product);

	public Product getProductById(Integer productId);

}
