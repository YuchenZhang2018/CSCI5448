package com.ecommerceservice.service;

import java.util.List;
import java.util.Map;

import com.ecommerceservice.model.common.OrderModel;
import com.ecommerceservice.model.common.Product;
import com.ecommerceservice.model.common.Storage;
import com.ecommerceservice.model.user.Cart;
import com.ecommerceservice.model.user.Customer;

public interface CustomerService {
	public void signup(Customer c);
	public boolean login(String usrName,String email,String phone, String password);
	public void logout(String usrName);
	public Cart deleteProductFromCart(String customerId, List<Storage> storage);
	public Cart addProduct2Cart(String customerId, List<Storage> products);
	public List<Product> searchProductInStorage(Map<String,String> searchfilter);
	public OrderModel checkout(String customerId);
	public Customer getCustomerById(String customerId);
	
}
