package com.ecommerceservice.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ecommerceservice.model.user.Customer;

public class CustomerDao implements ICustomerDao{
	
	public boolean saveCustomer(Customer customer) {
		Session session = HibernateUtils.openSession();
		Transaction ts = session.beginTransaction();
//		session.save(customer.getCart());

        session.save(customer);
       
        ts.commit();

        session.close();
        return true;
	}
	@Override
	public Customer getCustomer(Map<String,String> filterMap) {
		if (filterMap.isEmpty()) {
			return null;
		}
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		String hql = "select distinct c from Customer c where 1=1";
		List<String> filterValues = new ArrayList<String>();
		
		for(String name :filterMap.keySet()) {
			hql+="and c."+name+"=?";
			filterValues.add(filterMap.get(name));
		}
		Query query = session.createQuery(hql);
		for(int i=0;i<filterValues.size();i++) {
			query.setParameter(i,filterValues.get(i));
		}
		List list = query.list();
//		List list = session.createQuery("select distinct c from Customer c where c.name=:name").setString("name", name).list();
		Customer p =null;
		for (Iterator iterator = list.iterator();iterator.hasNext();) {
			p = (Customer) iterator.next();
		}
		session.close();
		return p;
	}
	
	
	@Override
	public Customer getCustomerById(String id) {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		Customer c= (Customer) session.get(Customer.class, id);
		session.close();
		return c;
	}
	@Override
	public void updateCustomer(Customer customer) {
		// Session session = sessionFactory.openSession();
		Session session = HibernateUtils.openSession();
	    session.beginTransaction();
	    //获取user ，处于持久化（Persistent）状态
	    Customer cur=getCustomerById(customer.getId());
	    //此时修改user的属性
	    cur = getNewCustomer(cur,customer);
	    session.update(cur);
	    //提交事务
	    session.getTransaction().commit();
	    session.close();
	
	}
	private Customer getNewCustomer(Customer past, Customer cur) {
		past.setAddress(cur.getAddress());
		past.setEmail(cur.getEmail());
		past.setPassport(cur.getPassport());
		past.setPhone(cur.getPhone());
		past.setPaymentInfo(cur.getPaymentInfo());
		past.getCart().setStorageList(cur.getCart().getStorageList());
		return past;
	}
	@Override
	public void deleteCustomer(Customer customer) {
		Session session = HibernateUtils.openSession();
	    session.beginTransaction();
	    Customer cur=getCustomerById(customer.getId());
	    session.delete(cur);
	    //提交事务
	    session.getTransaction().commit();
	    session.close();
		
	}
	
    
}
