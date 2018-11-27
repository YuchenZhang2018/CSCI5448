package com.ecommerceservice.model.common;

import java.util.List;

public class Order {
	private List<Storage> productList;
	private String customerID;
	private String state;
	private String orderID;
	public Order() {
		super();
	}
	public Order(List<Storage> productList, String customerID, String state, String orderID) {
		super();
		this.productList = productList;
		this.customerID = customerID;
		this.state = state;
		this.orderID = orderID;
	}
	public double getTotalCost() {
		double total = 0.0;
		for(Storage product:productList) {
			total += product.getPrice();
		}
		return total;
	}
	public List<Storage> getProductList() {
		return productList;
	}
	public void setProductList(List<Storage> productList) {
		this.productList = productList;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	
	
}
