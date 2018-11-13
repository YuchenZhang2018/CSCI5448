package com.zhang.ecommerceservice.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.zhang.ecommerceservice.model.common.Product;
import com.zhang.ecommerceservice.model.common.Storage;

public class StorageDao implements IStorageDao{

	@Override
	public void addStorage(Storage storage) {
		Storage queryRst=getStorage(storage.getProduct());
		Session session = HibernateUtils.openSession();
		session.beginTransaction();
		
		if(null==queryRst) {
			session.save(storage);
		}else {
			queryRst.setNum(queryRst.getNum()+storage.getNum());
			session.update(queryRst);
		}
		session.getTransaction().commit();
	    session.close();
	}

	@Override
	public boolean delStorage(Storage storage) {
		Storage queryRst=getStorage(storage.getProduct());
		Session session = HibernateUtils.openSession();
		session.beginTransaction();
		if(null==queryRst || queryRst.getNum()<storage.getNum()) {
			return false;
		}
		queryRst.setNum(queryRst.getNum()-storage.getNum());
		session.update(queryRst);
		session.getTransaction().commit();
	    session.close();
	    return true;	
	}

	@Override
	public Storage getStorage(Product product) {
		Session session = HibernateUtils.openSession();
		session.beginTransaction();
		String hql="from Storage s where PRODUCTNAME=? and BRAND=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, product.getProductName());
		query.setParameter(1, product.getBrand());
		List rstlist = query.list();
		if(rstlist.isEmpty()) {
			return null;
		}
		Storage rst = (Storage)rstlist.get(0);
		session.close();
		return rst;
		
	}
	
	

}
