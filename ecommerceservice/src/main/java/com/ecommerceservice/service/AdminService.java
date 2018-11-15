package com.ecommerceservice.service;

import com.ecommerceservice.model.user.Customer;

public interface AdminService {
	void addCustomer(Customer customer);
	void updateCustomer(Customer customer);
}
