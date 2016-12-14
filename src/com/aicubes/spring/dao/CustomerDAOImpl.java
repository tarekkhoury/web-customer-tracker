package com.aicubes.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

import com.aicubes.spring.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	public CustomerDAOImpl() {
	}
// need to inject the session factory
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	//@Transactional
	public List<Customer> getCustomers() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query ... sort by last name
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		// execute query and get result set
		List<Customer> customers = theQuery.getResultList();
		
		// return the results
		return customers;
	}

	@Override
	public void addCustomer(Customer theCustomer) {
		// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				// add a customer
				currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {

		// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				// create a query ... sort by last name
				//Query<Customer> theQuery = currentSession.createQuery("from Customer c where c.id = "+theId , Customer.class);
				
				
				Customer theCustomer = currentSession.get(Customer.class, theId);

				
				// execute query and get result set
				//Customer customer = (Customer) theQuery.getResultList();
				
				// return the results
				return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//MY METHOOD
		// get customer to delete.
		Customer theCustomer = currentSession.get(Customer.class, theId);
		// delete customer
		currentSession.delete(theCustomer);
		
		//  TUTORIAL's METHOD:
		
//		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
//		theQuery.setParameter("customerId", theId);
//		theQuery.executeUpdate();
		
	}

}
