package com.ecommerceservice.dao;

import java.util.List;
import java.util.Map;


import com.ecommerceservice.model.user.Cart;
import com.ecommerceservice.model.user.Customer;
/**
 * Customer Dao: can save, get, update and delete customer
 */
public interface ICustomerDao {
	public boolean saveCustomer(Customer customer);
	public Customer getCustomer(Map<String,String> filterMap);
	public Customer getCustomerById(String id);
	public void updateCustomer(Customer customer);
	public void deleteCustomer(Customer customer);
}
