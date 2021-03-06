package com.ecommerceservice.dao;

import java.util.logging.Level;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ecommerceservice.model.common.OrderModel;
import com.ecommerceservice.model.common.Storage;
import com.ecommerceservice.model.user.Address;
import com.ecommerceservice.model.user.Admin;
import com.ecommerceservice.model.user.Cart;
import com.ecommerceservice.model.user.Customer;
import com.ecommerceservice.model.user.PaymentInfo;
import com.ecommerceservice.model.user.StorageAdmin;


/**
 * HibernateUtils: mainly used for open a session
 */
@SuppressWarnings("deprecation")
public class HibernateUtils {

    private static SessionFactory sessionFactory;

    private HibernateUtils(){}

    static {
    	java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        Configuration configuration = new Configuration().configure();
        configuration.addClass(Customer.class);
        configuration.addClass(Admin.class);
        configuration.addClass(StorageAdmin.class);
        configuration.addClass(Storage.class);
        configuration.addClass(OrderModel.class);
        
        sessionFactory = configuration.buildSessionFactory();
    }
    

    public static Session openSession(){
        return sessionFactory.openSession();
    }

}
