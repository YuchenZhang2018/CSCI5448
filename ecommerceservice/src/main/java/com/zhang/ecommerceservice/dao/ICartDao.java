package com.zhang.ecommerceservice.dao;

import com.zhang.ecommerceservice.model.user.Cart;

public interface ICartDao {
	public boolean saveCustomer(Cart cart);
	public Cart getCart(String id);
}
