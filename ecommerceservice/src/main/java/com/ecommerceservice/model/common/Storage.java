package com.ecommerceservice.model.common;

import java.util.UUID;

public class Storage {
	private String id;
	private Product product;
	private double num;
	public Storage() {
		id = UUID.randomUUID().toString();
	}
	public Storage(String id,Product product, double num) {
		this.id=UUID.randomUUID().toString();
		this.product = product;
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public double getNum() {
		return num;
	}
	public void setNum(double num) {
		this.num = num;
	}
	
}
