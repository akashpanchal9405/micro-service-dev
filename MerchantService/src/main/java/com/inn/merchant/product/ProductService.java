package com.inn.merchant.product;

import com.inn.merchant.Product;

public interface ProductService {
	
	public Product addProductDetails(Product product);
	
	public Product getProductDetails(Integer productId);

}
