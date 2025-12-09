package com.inn.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.inn.transaction.entity.Order;
import com.inn.transaction.entity.Product;

@Service
public class OrderProcessingHandler {

	@Autowired
	private OrderService orderService;

	@Autowired
	private InventoryService inventoryService;

	@Autowired
	private NotificationHandler notificationHandler;

	@Autowired
	private AuditLogHandler auditLogHandler;

	@Autowired
	private ProductRecommendationHandler recommendationHandler;

	@Transactional(propagation = Propagation.REQUIRED)
	public Order placeOrder(Order order) {
		// get product from inventory
		Product existingProduct = inventoryService.getProductById(order.getProductId());

		// validate stock availability < (stockQuantity)
		validateStockAvailability(order, existingProduct);
		Order orderPlaced = null;

		// update total price in order entity
		order.setPrice(order.getQuantity() * existingProduct.getPrice());
		try {
			// save order
			orderPlaced = orderService.saveOrder(order);

			// update inventory
			updateInventoryStock(order, existingProduct);
			auditLogHandler.logAuditDetails(orderPlaced, "order placement succeeded");
		} catch (Exception e) {
//			REQUIRES_NEW - if above transaction rollback then audit also rollback in REQUIRED propagation to resolve that we can add Propagation.REQUIRES_NEW
			// at the top of audit() method, if method fails still audit() method persist in
			// auditing table for monitoring purpose.
			auditLogHandler.logAuditDetails(orderPlaced, "order placement failed: " + e.getMessage());
		}

		// send notification to user and this method will not participate in any
		// transaction
		// if below line add in existing transaction it throw exception so better to
		// write in separate method
//		notificationHandler.sendOrderConfirmationNotification(orderPlaced);

		// to execute Propagation.NOT_SUPPORTED
		recommendationHandler.getRecommendations();

		// to execute Propagation.SUPPORTS
		getCustomerDetails();

		return orderPlaced;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void getCustomerDetails() {
		System.out.println("customer details fetched...");
	}

	public Order processOrder(Order order) {
		// place order from here
		Order orderPlaced = placeOrder(order);

		// send notification without any transaction
		notificationHandler.sendOrderConfirmationNotification(orderPlaced);
		return orderPlaced;
	}

	private void validateStockAvailability(Order order, Product existingProduct) {
		if (existingProduct.getStockQuantity() < order.getQuantity()) {
			throw new RuntimeException("Items out of stock!");
		}
	}

	private void updateInventoryStock(Order order, Product existingProduct) {
		Integer availableQuantity = existingProduct.getStockQuantity() - order.getQuantity();
		existingProduct.setStockQuantity(availableQuantity);
		inventoryService.updateProductDetails(existingProduct);
	}

}
