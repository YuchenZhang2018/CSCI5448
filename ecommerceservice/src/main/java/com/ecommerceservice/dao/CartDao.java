package com.ecommerceservice.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.ecommerceservice.model.user.Cart;
import com.ecommerceservice.model.user.Customer;

@Component
public class CartDao implements ICartDao{
	public boolean saveCustomer(Cart cart) {
		Session session = HibernateUtils.openSession();
		Transaction ts = session.beginTransaction();
        session.save(cart);
        ts.commit();

        session.close();
        return true;
	}
	
	public Cart getCart(String id) {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		List list = session.createQuery("select distinct c from Cart c where c.id=:id").setString("id", id).list();
		Cart p =null;
		         for (Iterator iterator = list.iterator();iterator.hasNext();) {
		             p = (Cart) iterator.next();
		         }
		         session.close();
		         return p;
	}
}
