package com.aicubes.spring.service;

import java.util.List;

import com.aicubes.spring.entity.Customer;

public interface CustomerService {

	
public List<Customer> getCustomers();

public void addCustomer(Customer theCustomer);

public Customer getCustomer(int theId);

public void deleteCustomer(int theId);
	
}
