package com.ecommerceservice.dao;

import java.util.List;

import com.ecommerceservice.model.common.OrderModel;

/**
 * Order Dao: can save order, get order by orderId  and get orders by customerId
 */
public interface IOrderDao {
	String saveOrder(OrderModel order);
	OrderModel getOrderById(String orderID);
	List<OrderModel> getOrdersByCustomer(String CustomerId);

}
