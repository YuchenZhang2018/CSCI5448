package com.ecommerceservice.service;

import java.util.List;

import com.ecommerceservice.dao.IOrderDao;
import com.ecommerceservice.dao.OrderDao;
import com.ecommerceservice.model.common.OrderModel;

public class OrderServiceImpl implements OrderService{
	private IOrderDao dao = new OrderDao();

	@Override
	public String saveOrder(OrderModel order) {
		
		return dao.saveOrder(order);
	}

	@Override
	public OrderModel getOrderById(String orderID) {
		
		return dao.getOrderById(orderID);
	}

	@Override
	public List<OrderModel> getOrdersByCustomerID(String customerID) {
		
		return dao.getOrdersByCustomer(customerID);
	}

}
