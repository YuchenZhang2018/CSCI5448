package com.ecommerceservice.dao;

import com.ecommerceservice.model.user.Cart;

public interface ICartDao {
	public boolean saveCustomer(Cart cart);
	public Cart getCart(String id);
}
