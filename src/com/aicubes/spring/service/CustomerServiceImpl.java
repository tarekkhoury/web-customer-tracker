package com.aicubes.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aicubes.spring.dao.CustomerDAO;
import com.aicubes.spring.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	// need to inject Customer DAO
	
	@Autowired
	private CustomerDAO customerDAO;
	
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}


	@Override
	@Transactional
	public void addCustomer(Customer theCustomer) {
		customerDAO.addCustomer(theCustomer);
		
	}


	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		
		return customerDAO.getCustomer(theId);
	}


	@Override
	@Transactional

	public void deleteCustomer(int theId) {
		customerDAO.deleteCustomer(theId);
	}

//	@Transactional
//	public void addCustomers(Customer theCustomer) {
//		//customerDAO.add
//		//return customerDAO.getCustomers();
//	}
	
	
}
