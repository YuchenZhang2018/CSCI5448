package com.ecommerceservice.model.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ecommerceservice.model.common.*;



public class Customer {
	private String name;
	private Address address;
	private String phone;
	private String email;
	private Cart cart;
	private String id;
	private PaymentInfo paymentInfo;
	private boolean storageState;
	private boolean paymentState;
	private boolean addressState;
	private List<Checker> checkers = new ArrayList<Checker>();
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
		storageState=false;
		paymentState = false;
		addressState = false;
	}
	
	
	
	public boolean isStorageState() {
		return storageState;
	}

	public void setStorageState(boolean storageState) {
		this.storageState = storageState;
	}

	public boolean isPaymentState() {
		return paymentState;
	}

	public void setPaymentState(boolean paymentState) {
		this.paymentState = paymentState;
	}

	public boolean isAddressState() {
		return addressState;
	}

	public void setAddressState(boolean addressState) {
		this.addressState = addressState;
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
	public void attach(Checker checker) {
		checkers.add(checker);
	}
	public Order checkout() {
		for(Checker checker: checkers) {
			checker.checkoutCheck();
		}
		if(storageState && paymentState && addressState) {
			Order order = new Order(cart.getStorageList(),id,null,null);
			return order;
		}
		return null;
	}
}
