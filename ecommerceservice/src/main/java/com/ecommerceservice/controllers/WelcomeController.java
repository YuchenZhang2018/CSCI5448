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

import com.ecommerceservice.model.user.Customer;
import com.ecommerceservice.model.user.RoleModel;
import com.ecommerceservice.service.CustomerService;
import com.ecommerceservice.service.CustomerServiceImpl;


@Controller

public class WelcomeController {
//	@Autowired
	private CustomerService customerService = new CustomerServiceImpl();

    @RequestMapping( "/")
	public String welcome(Model model) {
		return "index";
	}
	
	@RequestMapping("/login")
	public String chooseRoleandOperation(@ModelAttribute RoleModel role) {
		String roleStr= role.getRole();
		if("customer".equals(role.getRole())) {
//		    System.out.printf("user: {}  password: {}",role.getUserName(),role.getPassport());;
//			customerService.login(role.getUserName(), null, null, role.getPassport());
//			return"redirect:/customerPage";
			if("signup".equals(role.getOperation())) {
				return "customerSignup";
			}
			return "customerSignin";
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
//	public static void main(String[] args) throws Exception {
//		SpringApplication.run(WelcomeController.class, args);
//	}
}
