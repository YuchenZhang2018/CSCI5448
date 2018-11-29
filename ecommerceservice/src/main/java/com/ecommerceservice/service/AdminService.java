package com.ecommerceservice.service;

import com.ecommerceservice.model.user.Admin;
import com.ecommerceservice.model.user.Customer;
import com.ecommerceservice.model.user.StorageAdmin;

/**
 * admin service, can add customer, update customer,
 * signup admin, signin admin, delete admin by adminId, get admin by name and phone
 */
public interface AdminService {
	void addCustomer(Customer customer);
	void updateCustomer(Customer customer);
	void signup(Admin admin);
	boolean signin(Admin admin);
	void delete(String id);
	Admin getAdminByNameAndPhone(Admin admin);
}

