package com.ecommerceservice.model.common;

import java.util.List;
import java.util.UUID;

/**
 * Model of Order,property productStr is the string type of product list
 */
public class OrderModel {
	private String orderID;
	private String productStr;
	private String customerID;
	private String state;
	
	private String discountStrategyInfo;
	private double totalcost;
	private double saving;
	private double tax;
	
	public OrderModel() {
		orderID = UUID.randomUUID().toString();
	}
	public OrderModel(String productStr, String customerID, String state, String discountStrategyInfo, double totalcost,
			double saving, double tax) {
		super();
		orderID = UUID.randomUUID().toString();
		this.productStr = productStr;
		this.customerID = customerID;
		this.state = state;
		this.discountStrategyInfo = discountStrategyInfo;
		this.totalcost = totalcost;
		this.saving = saving;
		this.tax = tax;
		
	}
	
	public String getProductStr() {
		return productStr;
	}
	public void setProductStr(String productStr) {
		this.productStr = productStr;
	}
	public String getDiscountStrategyInfo() {
		return discountStrategyInfo;
	}
	public void setDiscountStrategyInfo(String discountStrategyInfo) {
		this.discountStrategyInfo = discountStrategyInfo;
	}
	public double getTotalcost() {
		return totalcost;
	}
	public void setTotalcost(double totalcost) {
		this.totalcost = totalcost;
	}
	public double getSaving() {
		return saving;
	}
	public void setSaving(double saving) {
		this.saving = saving;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
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
