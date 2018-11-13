package com.zhang.ecommerceservice.dao;

import java.util.List;
import java.util.Map;

import com.zhang.ecommerceservice.model.common.Product;
import com.zhang.ecommerceservice.model.user.Cart;
import com.zhang.ecommerceservice.model.user.Customer;

public interface ICustomerDao {
	public boolean saveCustomer(Customer customer);
	public Customer getCustomer(Map<String,String> filterMap);
	public Customer getCustomerById(String id);
	public void updateCustomer(Customer customer);
	public void deleteCustomer(Customer customer);
}
