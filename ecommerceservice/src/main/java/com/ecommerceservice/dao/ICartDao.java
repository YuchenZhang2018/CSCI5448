package com.ecommerceservice.dao;

import com.ecommerceservice.model.user.Cart;

public interface ICartDao {
	public boolean saveCart(Cart cart);
	public Cart getCart(String id);
}
