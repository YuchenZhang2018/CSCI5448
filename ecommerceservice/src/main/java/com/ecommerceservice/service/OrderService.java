package com.ecommerceservice.service;

import java.util.List;

import com.ecommerceservice.model.common.OrderModel;
/**
 * Order service, can save order, get order by orderId, get orders by customerId
 */
public interface OrderService {
	String saveOrder(OrderModel order);
	OrderModel getOrderById(String orderID);
	List<OrderModel> getOrdersByCustomerID(String customerID);	
}
