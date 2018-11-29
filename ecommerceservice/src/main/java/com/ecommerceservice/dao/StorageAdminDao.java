package com.ecommerceservice.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import com.ecommerceservice.model.user.StorageAdmin;
/**
 * StorageAdmin Dao: can save storageAdmin, delete storageAdmin by id, and get storage admin by id or by name and phone.
 */
public class StorageAdminDao implements IStorageAdminDao{

	@Override
	public void saveAdmin(StorageAdmin admin) {
		Session session = HibernateUtils.openSession();
		session.beginTransaction();
		session.save(admin);
		session.getTransaction().commit();
        session.close();		
	}

	@Override
	public void deleteAdminById(StorageAdmin admin) {
		Session session = HibernateUtils.openSession();
		session.beginTransaction();
		
		StorageAdmin s= (StorageAdmin) session.get(StorageAdmin.class, admin.getId());
		session.delete(s);
		
		session.getTransaction().commit();
        session.close();		
	}

	@Override
	public StorageAdmin getStorageAdminById(String id) {
		Session session = HibernateUtils.openSession();
		session.beginTransaction();
		StorageAdmin s= (StorageAdmin) session.get(StorageAdmin.class, id);
        session.close();
		return s;
	}

	@Override
	public StorageAdmin getStorageAdminByNameAndPhone(StorageAdmin admin) {
		Session session = HibernateUtils.openSession();
		session.beginTransaction();		
		String hql = "select distinct s from StorageAdmin s where s.name=? and s.phone=?";	
		Query query = session.createQuery(hql);
		query.setParameter(0,admin.getName());
		query.setParameter(1,admin.getPhone());		
		List list = query.list();
		StorageAdmin p =null;
		for (Iterator iterator = list.iterator();iterator.hasNext();) {
			p = (StorageAdmin) iterator.next();
		}
		session.close();
		return p;
	}

}
