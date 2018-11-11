package com.zhang.ecommerceservice.service;

import com.zhang.ecommerceservice.model.user.Customer;

public interface CustomerService {
	public void signup(Customer c);
	public void login(String usrName, String password);
	public void logout(String usrName);


}
