package com.ecommerceservice.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ecommerceservice.model.common.Product;
import com.ecommerceservice.model.user.Address;
import com.ecommerceservice.model.user.Cart;
import com.ecommerceservice.model.user.Customer;
import com.ecommerceservice.model.user.PaymentInfo;


@SuppressWarnings("deprecation")
public class HibernateUtils {

    private static SessionFactory sessionFactory;

    private HibernateUtils(){}

    static {
//    	final String HIB_CONFIG_PATH="src/hibernate.cfg.xml";
        Configuration configuration = new Configuration().configure();
        configuration.addClass(Customer.class);
        configuration.addClass(Cart.class);
        configuration.addClass(Product.class);
        
        sessionFactory = configuration.buildSessionFactory();
    }
    
    // 获得Session对象
    public static Session openSession(){
        return sessionFactory.openSession();
    }

}
