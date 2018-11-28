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
import com.ecommerceservice.dao.IOrderDao;
import com.ecommerceservice.dao.IProductDao;
import com.ecommerceservice.dao.IStorageDao;
import com.ecommerceservice.dao.OrderDao;
import com.ecommerceservice.dao.ProductDao;
import com.ecommerceservice.dao.StorageDao;
import com.ecommerceservice.model.common.AddressChecker;
import com.ecommerceservice.model.common.OrderModel;
import com.ecommerceservice.model.common.PaymentInfoChecker;
import com.ecommerceservice.model.common.Product;
import com.ecommerceservice.model.common.ProductSearchFilter;
import com.ecommerceservice.model.common.Storage;
import com.ecommerceservice.model.common.StorageChecker;
import com.ecommerceservice.model.user.Cart;
import com.ecommerceservice.model.user.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	private ICustomerDao customerDao = new CustomerDao();
	private IProductDao productDao = new ProductDao();
	private IOrderDao orderDao = new OrderDao();

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
	public Cart addProduct2Cart(String customerId,List<Storage> products) {
    	Customer c = customerDao.getCustomerById(customerId);
    	
    	for(Storage product:products) {
			c.getCart().addItem(product);
		}
    	Session session = HibernateUtils.openSession();
		Transaction ts = session.beginTransaction();
		session.update(c);
        ts.commit();
        session.close();
        return c.getCart();
	}
    @Override
	public Cart deleteProductFromCart(String customerId, List<Storage> product) {
    	Customer c = customerDao.getCustomerById(customerId);
    	Session session = HibernateUtils.openSession();
		Transaction ts = session.beginTransaction();
		for(Storage cur: product) {
			c.getCart().deleteItem(cur);
		}
		
		session.update(c.getCart());
        ts.commit();
        session.close();
        return c.getCart();
	}
    
    
	
	public boolean logout() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public boolean returnProducts(OrderModel order) {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public List<Product> searchProductInStorage(Map<String, String> searchfilter) {
		return productDao.searchProduct(searchfilter);
	}

	@Override
	public OrderModel checkout(String customerId) {
		Customer c = customerDao.getCustomerById(customerId);
    	new StorageChecker(c);
    	new PaymentInfoChecker(c);
    	new AddressChecker(c);
    	OrderModel order = c.checkout();
    	orderDao.saveOrder(order);
		return order;
	}

	@Override
	public Customer getCustomerById(String customerId) {
	
		return customerDao.getCustomerById(customerId);
	}


}
