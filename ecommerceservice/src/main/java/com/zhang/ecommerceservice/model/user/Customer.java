package com.zhang.ecommerceservice.model.user;

import java.util.ArrayList;
import java.util.List;

import com.zhang.ecommerceservice.model.common.*;




public class Customer {
	private String name;
	private Address address;
	private String phone;
	private String email;
	private Cart cart;
	private String id;
	private PaymentInfo paymentInfo;
	public PaymentInfo getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(PaymentInfo paymentInfo) {
		this.paymentInfo = paymentInfo;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	private String passport;
	
	public Customer() {
		cart = new Cart();
		id = "randID";
	}
	
	public Customer(String name, Address address, String phone, String email) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		cart = new Cart();
		id = "randID";
	}
	
	public List<Product> searchProducts(ProductSearchFilter filter){
		List<Product> searchResult = new ArrayList<Product>();
		//to do search
		return searchResult;
	}

	public Cart addProduct2Cart(List<Product> products) {
		for(Product product:products) {
			cart.addItem(product);
		}
		return cart;
	}
	public Cart deleteProductFromCart(Product product) {
		if(cart.getProductList().contains(product)) {
			cart.deleteItem(product);
		}
		return cart;
	}
	public boolean login(String passport) {
		//check from datebase
		return true;
	}
	public boolean logout() {
		//to do
		return true;
	}
	
	public boolean returnProducts(Order order) {
		//to do return
		return true;
	}
	public boolean checkOut() {
		//to do
		return true;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Cart getCart() {
		return cart;
	}

	public String getId() {
		return id;
	}
}
