package com.inn.order.service;

import java.util.concurrent.CompletableFuture;

import com.inn.order.dto.OrderRequest;

public interface OrderService {
	
	public CompletableFuture<String> placeOrder(OrderRequest orderRequest);

}
