package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query ... sort by last name
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer order by lastName", 
											Customer.class);
		
		// execute query and get result lis
		List<Customer> customers = theQuery.getResultList();
		
		// return the results		
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save the customer ... finally LOL
		currentSession.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomers(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();
		
	Customer theCostumer = currentSession.get(Customer.class, theId);
		
		return theCostumer;
	}

	@Override
	public void deleteCustomer(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQury = 
	currentSession.createQuery("delete from Customer where id=:customerId");
		
		theQury.setParameter("customerId", theId);
		
		theQury.executeUpdate();
		
	}

}
