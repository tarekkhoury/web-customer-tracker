package com.aicubes.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aicubes.spring.dao.CustomerDAO;
import com.aicubes.spring.entity.Customer;
import com.aicubes.spring.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {


//	// need to inject the DAO into this controller
//	@Autowired
//	private CustomerDAO customerDAO;
	
	
	// need to inject the CustomerService (instead of CustomerDAO)
		@Autowired
		private CustomerService customerService ;
		
		
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get the customers from the DAO
		List<Customer> theCustomers = customerService.getCustomers();		
		
		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		
		return "list-customers";
	}
	
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);

		return "customer-form";
	}
	
	
	
	@PostMapping("/addCustomer")
	public String addCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		
		customerService.addCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	
	@GetMapping("/showFormForUpdate")
	public String showFormForAdd(@RequestParam("customerId") int theId, Model theModel) {
		
		// get the customer from the Service
		Customer theCustomers = customerService.getCustomer(theId);		
	
		
		// set the customer as a model attribute to pre populate the form
		// add the customers to the model
		theModel.addAttribute("customer", theCustomers);
		
		// send over to our form
		
		return "customer-form";
	}
	
	
	
	
	@GetMapping("/delete")
	public String showFormForAdd(@RequestParam("customerId") int theId) {
		
		// get the customer from the Service
		customerService.deleteCustomer(theId);		
	
		
		// set the customer as a model attribute to pre populate the form
		// add the customers to the model
		//theModel.addAttribute("customer", theCustomers);
		
		// send over to our form
		
		return "redirect:/customer/list";
	}
	
	
	
	

}
