package com.zhang.ecommerceservice.service;

import com.zhang.ecommerceservice.model.user.Customer;

public interface AdminService {
	void addCustomer(Customer customer);
	void updateCustomer(Customer customer);
}
