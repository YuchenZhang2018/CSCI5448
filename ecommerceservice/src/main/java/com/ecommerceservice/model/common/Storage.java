package com.ecommerceservice.model.common;

import java.util.UUID;

/**
 * Storage model
 */
public class Storage {
	private String id;
	private String productName;
	private double num;
	private double price;
	public Storage() {
		id = UUID.randomUUID().toString();
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Storage(String id, String productName, double num, double price) {
		super();
		this.id = id;
		this.productName = productName;
		this.num = num;
		this.price = price;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public double getNum() {
		return num;
	}
	public void setNum(double num) {
		this.num = num;
	}
	
}
