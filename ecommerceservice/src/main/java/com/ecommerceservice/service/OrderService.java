package com.ecommerceservice.service;

import java.util.List;

import com.ecommerceservice.model.common.OrderModel;

public interface OrderService {
	String saveOrder(OrderModel order);
	OrderModel getOrderById(String orderID);
	List<OrderModel> getOrdersByCustomerID(String customerID);	
}
