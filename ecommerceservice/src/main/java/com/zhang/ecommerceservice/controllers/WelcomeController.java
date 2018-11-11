package com.zhang.ecommerceservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhang.ecommerceservice.model.user.Customer;
import com.zhang.ecommerceservice.service.CustomerService;

@Controller
public class WelcomeController {
	@Autowired
	private CustomerService customerService;

    @RequestMapping(value = "/welcome", method=RequestMethod.GET)
	public String welcome(Model model) {
		model.addAttribute("firstName","Yuchen");
		return "customerAddPage";
	}
	
	@RequestMapping(value= "/customer/signup", method = RequestMethod.POST)
	public String signupCustomer(@ModelAttribute("customer") Customer c) {
		if(c.getId() == null){
			//new person, add it
			this.customerService.signup(c);
		}else{
			//existing person, call update
			
		}
		
		return "redirect:/welcome";
	}
}
