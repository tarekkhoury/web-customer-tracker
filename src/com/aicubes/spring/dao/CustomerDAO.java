package com.aicubes.spring.dao;

import java.util.List;

import com.aicubes.spring.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void addCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
}
