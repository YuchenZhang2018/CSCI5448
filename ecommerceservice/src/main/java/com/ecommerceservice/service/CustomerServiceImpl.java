package com.ecommerceservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerceservice.dao.CustomerDao;
import com.ecommerceservice.dao.HibernateUtils;
import com.ecommerceservice.dao.ICustomerDao;
import com.ecommerceservice.model.common.Order;
import com.ecommerceservice.model.common.Product;
import com.ecommerceservice.model.common.ProductSearchFilter;
import com.ecommerceservice.model.user.Cart;
import com.ecommerceservice.model.user.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	private ICustomerDao customerDao = new CustomerDao();

	@Override
	public void signup(Customer c) {
		customerDao.saveCustomer(c);
	}

	@Override
	public boolean login(String usrName,String email,String phone, String password) {
		Map<String,String> mapfilter = new HashMap<String,String>();
		if(null!=usrName) {
			mapfilter.put("name",usrName);
		}
		if(null!=email) {
			mapfilter.put("email", email);
		}
		if(null!= phone) {
			mapfilter.put("phone", phone);
		}
		Customer c = customerDao.getCustomer(mapfilter);
		if(c==null) {
			return false;
		}
		if(c.getPassport().equals(password)) {
			return true;
		}
		return false;
//		return true;
	}

	@Override
	public void logout(String usrName) {
		// TODO Auto-generated method stub

	}
	public List<Product> searchProducts(ProductSearchFilter filter){
		List<Product> searchResult = new ArrayList<Product>();
		//to do search
		return searchResult;
	}
	@Override
	public Cart addProduct2Cart(String customerId,List<Product> products) {
    	Customer c = customerDao.getCustomerById(customerId);
    	
    	for(Product product:products) {
			c.getCart().addItem(product);
		}
    	Session session = HibernateUtils.openSession();
		Transaction ts = session.beginTransaction();
		session.save(c.getCart());
        ts.commit();
        session.close();
        return c.getCart();
	}
    @Override
	public Cart deleteProductFromCart(String customerId, Product product) {
    	Customer c = customerDao.getCustomerById(customerId);
    	Session session = HibernateUtils.openSession();
		Transaction ts = session.beginTransaction();
		c.getCart().deleteItem(product);
		session.save(c.getCart());
        ts.commit();
        session.close();
        return c.getCart();
	}
    
    
	
	public boolean logout() {
		//to do
		return true;
	}
	
	public boolean returnProducts(Order order) {
		//to do return
		return true;
	}
	public boolean checkOut() {
		//to do
		return true;
	}


}
