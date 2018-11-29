package com.ecommerceservice.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ecommerceservice.model.user.Admin;
import com.ecommerceservice.model.user.Customer;

/**
 * Admin Dao: can save, delete admin, can get admin by adminId or by admin name and phone
 */
public class AdminDao implements IAdminDao{

	@Override
	public void saveAdmin(Admin admin) {
		
		Session session = HibernateUtils.openSession();
		Transaction ts = session.beginTransaction();
		session.save(admin);       
        ts.commit();

        session.close();
	}

	@Override
	public void deleteAdmin(Admin admin) {
		Admin adminCur = null;
		if(admin.getAdminId() !=null) {
			adminCur = getAdminById(admin.getAdminId());		
		} else {
			adminCur = getAdminByNameAndPhone(admin);		
		}
		Session session = HibernateUtils.openSession();
		session.beginTransaction();
		session.delete(adminCur);
		session.close();
		
	}

	@Override
	public Admin getAdminById(String id) {
		Session session = HibernateUtils.openSession();
		session.beginTransaction();
		Admin admin= (Admin) session.get(Admin.class, id);
		session.close();
		return admin;
	}

	@Override
	public Admin getAdminByNameAndPhone(Admin admin) {
		Session session = HibernateUtils.openSession();
		session.beginTransaction();		
		String hql = "select distinct a from Admin a where a.name=? and a.phone=?";	
		Query query = session.createQuery(hql);
		query.setParameter(0,admin.getName());
		query.setParameter(1,admin.getPhone());		
		List list = query.list();
		Admin p =null;
		for (Iterator iterator = list.iterator();iterator.hasNext();) {
			p = (Admin) iterator.next();
		}
		session.close();
		return p;
	}

}
