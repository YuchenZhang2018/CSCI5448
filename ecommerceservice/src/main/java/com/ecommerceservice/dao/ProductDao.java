package com.ecommerceservice.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ecommerceservice.model.common.Product;
import com.ecommerceservice.model.common.ProductSearchFilter;
import com.ecommerceservice.model.user.Customer;

public class ProductDao implements IProductDao{
	private IStorageDao storageDao = new StorageDao();

	@Override
	public List<Product> searchProduct(Map<String,String> productSearchFilter) {
		if (productSearchFilter.isEmpty()) {
			return null;
		}
		Session session = HibernateUtils.openSession();
		session.beginTransaction();
		
		String hql = "select distinct s from Storage s where 1=1 ";
		List<String> filterValues = new ArrayList<String>();
		
		for(String name :productSearchFilter.keySet()) {
			if(productSearchFilter.get(name).isEmpty()) {
				continue;
			}
			hql+="and s."+name+"=?";
			filterValues.add(productSearchFilter.get(name));
		}
		Query query = session.createQuery(hql);
		for(int i=0;i<filterValues.size();i++) {
			query.setParameter(i,filterValues.get(i));
		}
		List list = query.list();
//		List list = session.createQuery("select distinct c from Customer c where c.name=:name").setString("name", name).list();
		List<Product> p =null;
		for (Iterator iterator = list.iterator();iterator.hasNext();) {
			p.add((Product) iterator.next());
		}
		session.close();
		return p;
	}

}
