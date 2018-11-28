package com.ecommerceservice.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ecommerceservice.model.common.OrderModel;
import com.ecommerceservice.model.user.Customer;

public class OrderDao implements IOrderDao{

	@Override
	public String saveOrder(OrderModel order) {
		Session session = HibernateUtils.openSession();
		Transaction ts = session.beginTransaction();
        session.save(order);      
        ts.commit();
        session.close();
        return order.getOrderID();
		
	}

	@Override
	public OrderModel getOrderById(String orderID) {
		Session session = HibernateUtils.openSession();
		session.beginTransaction();
		OrderModel o= (OrderModel) session.get(OrderModel.class, orderID);
		session.close();
		return o;
	}

	@Override
	public List<OrderModel> getOrdersByCustomer(String customerId) {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();	
		String hql = "select from Order o where o.CUSTOMERID="+customerId;	
		Query query = session.createQuery(hql);
		
		List list = query.list();
//		List list = session.createQuery("select distinct c from Customer c where c.name=:name").setString("name", name).list();
		List<OrderModel> orders =new ArrayList<OrderModel>();
		for (Iterator iterator = list.iterator();iterator.hasNext();) {
			orders.add((OrderModel) iterator.next());
		}
		session.close();
		return orders;
	}

}
