package com.ecommerceservice.model.common;

public class ProductSearchFilter {
	private String brand;
	private String categary;
	private String productName;
	public ProductSearchFilter(String brand, String categary, String productName) {
		super();
		this.brand = brand;
		this.categary = categary;
		this.productName = productName;
	}
	public ProductSearchFilter() {
		super();
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategary() {
		return categary;
	}
	public void setCategary(String categary) {
		this.categary = categary;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
	

}
