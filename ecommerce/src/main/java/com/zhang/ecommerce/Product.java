package com.zhang.ecommerce;


public class Product {
	
	private String productName;
	private String category;
	private String brand;
	private double price;
	private String info;
	
	public Product() {
		super();
	}
	public Product(String productName, String category, String brand, double price, String info) {
		super();
		this.productName = productName;
		this.category = category;
		this.brand = brand;
		this.price = price;
		this.info = info;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}

}
