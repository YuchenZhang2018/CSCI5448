package com.ecommerceservice.dao;

import java.util.List;

import com.ecommerceservice.model.common.OrderModel;

public interface IOrderDao {
	String saveOrder(OrderModel order);
	OrderModel getOrderById(String orderID);
	List<OrderModel> getOrdersByCustomer(String CustomerId);

}
