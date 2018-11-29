package com.ecommerceservice.dao;

import com.ecommerceservice.model.user.Cart;
/**
 * Cart Dao: can save, get cart
 */
public interface ICartDao {
	public boolean saveCart(Cart cart);
	public Cart getCart(String id);
}
