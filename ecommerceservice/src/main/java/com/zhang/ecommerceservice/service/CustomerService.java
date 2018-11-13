package com.zhang.ecommerceservice.service;

import java.util.List;

import com.zhang.ecommerceservice.model.common.Product;
import com.zhang.ecommerceservice.model.user.Cart;
import com.zhang.ecommerceservice.model.user.Customer;

public interface CustomerService {
	public void signup(Customer c);
	public boolean login(String usrName,String email,String phone, String password);
	public void logout(String usrName);
	public Cart deleteProductFromCart(String customerId, Product product);
	public Cart addProduct2Cart(String customerId, List<Product> products);


}
