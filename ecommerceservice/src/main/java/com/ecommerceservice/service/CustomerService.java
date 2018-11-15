package com.ecommerceservice.service;

import java.util.List;

import com.ecommerceservice.model.common.Product;
import com.ecommerceservice.model.user.Cart;
import com.ecommerceservice.model.user.Customer;

public interface CustomerService {
	public void signup(Customer c);
	public boolean login(String usrName,String email,String phone, String password);
	public void logout(String usrName);
	public Cart deleteProductFromCart(String customerId, Product product);
	public Cart addProduct2Cart(String customerId, List<Product> products);


}
