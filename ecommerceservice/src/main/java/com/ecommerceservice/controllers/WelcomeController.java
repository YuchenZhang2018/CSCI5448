package com.ecommerceservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerceservice.model.user.Admin;
import com.ecommerceservice.model.user.Customer;
import com.ecommerceservice.model.user.RoleModel;
import com.ecommerceservice.model.user.StorageAdmin;
import com.ecommerceservice.service.AdminService;
import com.ecommerceservice.service.AdminServiceImpl;
import com.ecommerceservice.service.CustomerService;
import com.ecommerceservice.service.CustomerServiceImpl;
import com.ecommerceservice.service.StorageAdminService;
import com.ecommerceservice.service.StorageAdminServiceImpl;


@Controller

public class WelcomeController {
//	@Autowired
	private CustomerService customerService = new CustomerServiceImpl();
	private StorageAdminService stgAdminService = new StorageAdminServiceImpl();
	private AdminService adminService = new AdminServiceImpl();
	
    @RequestMapping( "/")
	public String welcome(Model model) {
		return "index";
	}
	
	@RequestMapping("/login")
	public String chooseRoleandOperation(@ModelAttribute RoleModel role) {
		String roleStr= role.getRole();
		if("customer".equals(role.getRole())) {
			if("signup".equals(role.getOperation())) {
				return "customerSignup";
			}
			return "customerSignin";
		}
		if("admin".equals(role.getRole())) {
			if("signup".equals(role.getOperation())) {
				return "adminSignup";
			}
			return "adminSignin";
		}
		if("storageAdmin".equals(role.getRole())) {
			if("signup".equals(role.getOperation())) {
				return "storageAdminSignup";
			}
			return "storageAdminSignin";
		}
		
			
//		if(c.getId() == null){
//			//new person, add it
//			this.customerService.signup(c);
//		}else{
//			//existing person, call update
//			
//		}
		
		
		return "customerAddPage";
	}
	@RequestMapping("/customer/signup")
	public String customerSignup(@ModelAttribute Customer customer) {
		customerService.signup(customer);
		return "customerWelcome";
	}
	
	@RequestMapping("/customer/signin")
	public String customerSignin(@ModelAttribute Customer customer) {
		customerService.login(customer.getName(), null, null, customer.getPassport());
		return "customerWelcome";
	}
	@RequestMapping("/storageAdmin/signup")
	public String storageAdminSignup(@ModelAttribute StorageAdmin stgAdmin) {
		stgAdminService.signup(stgAdmin);
		return "customerWelcome";
	}
	
	@RequestMapping("/storageAdmin/signin")
	public String storageAdminSignin(@ModelAttribute StorageAdmin stgAdmin) {
		stgAdminService.signin(stgAdmin);
		return "customerWelcome";
	}
	@RequestMapping("/admin/signup")
	public String adminSignup(@ModelAttribute Admin admin) {
		adminService.signup(admin);
		return "customerWelcome";
	}
	
	@RequestMapping("/admin/signin")
	public String adminSignin(@ModelAttribute Admin admin) {
		adminService.signin(admin);
		return "customerWelcome";
	}

}
