package com.inn.order.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import com.inn.order.dto.InventoryResponse;
import com.inn.order.dto.OrderLineItemsDto;
import com.inn.order.dto.OrderRequest;
import com.inn.order.entity.Order;
import com.inn.order.entity.OrderLineItems;
import com.inn.order.exceptions.OrderNotPlacedException;
import com.inn.order.repository.OrderRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {

	private final OrderRepository orderRepository;

	private final WebClient.Builder webClientBuilder;

	@Override
	@CircuitBreaker(name = "inventory", fallbackMethod = "inventoryFallBack")
	@TimeLimiter(name = "inventory")
	@Retry(name = "inventory")
	public CompletableFuture<String> placeOrder(OrderRequest orderRequest) {
		List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList().stream().map(this::mapToDto)
				.toList();
		Order order = Order.builder().orderLineItems(orderLineItems).orderNumber(UUID.randomUUID().toString()).build();
		Boolean isInStock = processOrder(orderLineItems);
		if (isInStock) {
			orderRepository.save(order);
		} else {
			throw new OrderNotPlacedException("Product is not in stock, please try again later");
		}
		return CompletableFuture.supplyAsync(() -> "order placed Successfully");
	}

	// fallback method return type should be same as placeOrder() method otherwise
	// it won't work properly
	public CompletableFuture<String> inventoryFallBack(OrderRequest orderRequest, Exception exception) {
		return CompletableFuture.supplyAsync(() -> "something went wrong, please try after some time");
	}

	private Boolean processOrder(List<OrderLineItems> orderLineItems) {

		List<String> skuCodes = orderLineItems.stream().map(OrderLineItems::getSkuCode).toList();

		// before placing order we need to check item available in stock or not by using
		// WebClient
		InventoryResponse[] inventoryResponses = webClientBuilder.build().get()
				.uri("http://Inventory-Service/api/inventory",
						uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
				.retrieve().bodyToMono(InventoryResponse[].class).block();
		boolean isInStock = Arrays.stream(inventoryResponses).allMatch(InventoryResponse::getIsInStock);
		return isInStock;
	}

	private OrderLineItems mapToDto(OrderLineItemsDto orderLineItem) {
		return OrderLineItems.builder().price(orderLineItem.getPrice()).quantity(orderLineItem.getQuantity())
				.skuCode(orderLineItem.getSkuCode()).build();
	}

}
