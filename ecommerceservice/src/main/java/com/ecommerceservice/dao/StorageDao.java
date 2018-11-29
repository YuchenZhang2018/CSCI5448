package com.ecommerceservice.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.ecommerceservice.model.common.Storage;
import com.ecommerceservice.model.user.Customer;
/**
 * Storage Dao: can add, get, delete storage
 */
@Component
public class StorageDao implements IStorageDao{

	@Override
	public void addStorage(Storage storage) {
		Storage queryRst=getStorage(storage.getProductName());
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
		Storage queryRst=getStorage(storage.getProductName());
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
	public Storage getStorage(String productName) {
		Session session = HibernateUtils.openSession();
		session.beginTransaction();
		String hql="from Storage s where PRODUCTNAME=? ";
		Query query = session.createQuery(hql);
		query.setParameter(0, productName);
		List rstlist = query.list();
		if(rstlist.isEmpty()) {
			return null;
		}
		Storage rst = (Storage)rstlist.get(0);
		session.close();
		return rst;
		
	}

	@Override
	public List<Storage> getAllStorage() {
		Session session = HibernateUtils.openSession();
		session.beginTransaction();
		String hql="from Storage s where 1=1";
		Query query = session.createQuery(hql);
		List rstlist = query.list();
		if(rstlist.isEmpty()) {
			return null;
		}
		List<Storage> storageList = new ArrayList<Storage>();
		for (Iterator iterator = rstlist.iterator();iterator.hasNext();) {
			storageList.add((Storage) iterator.next());
		}
		return storageList;
	}
	
	

}
