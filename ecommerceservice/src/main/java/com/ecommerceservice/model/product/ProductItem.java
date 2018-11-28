package com.ecommerceservice.model.product;

import com.ecommerceservice.model.common.Storage;

public abstract class ProductItem implements Cloneable{
	
	protected String productName;
	protected String categary;
	protected double price;
	
	

	
	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getCategary() {
		return categary;
	}


	abstract String extraInfo();
	
	public Object clone() {
	      Object clone = null;
	      try {
	         clone = super.clone();
	      } catch (CloneNotSupportedException e) {
	         e.printStackTrace();
	      }
	      return clone;
	}
	public Storage getStorage(double num) {
		Storage storage =  new Storage();
		storage.setProductName(productName);
		storage.setPrice(price);
		storage.setNum(num);
		return storage;
	}
	
	

}
