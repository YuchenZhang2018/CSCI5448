package com.ecommerceservice.service;

import com.ecommerceservice.model.user.Admin;
import com.ecommerceservice.model.user.Customer;
import com.ecommerceservice.model.user.StorageAdmin;

public interface AdminService {
	void addCustomer(Customer customer);
	void updateCustomer(Customer customer);
	void signup(Admin admin);
	boolean signin(Admin admin);
	void delete(String id);
	Admin getAdminByNameAndPhone(Admin admin);
}

