package com.zhang.ecommerceservice.dao;

import com.zhang.ecommerceservice.model.user.Customer;

public interface ICustomerDao {
	public boolean saveCustomer(Customer customer);
	public Customer getCustomer(String name, String email, String phone);
}
