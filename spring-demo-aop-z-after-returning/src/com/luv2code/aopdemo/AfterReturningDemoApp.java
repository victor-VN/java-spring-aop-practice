package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {

		// read spring java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = 
				context.getBean("accountDAO", AccountDAO.class);
		
		// call method to find accounts
		List<Account> thAccounts = theAccountDAO.findAccounts();
		
		// display the accounts
		System.out.println("\n\nMain program: AfterReturningDemoApp");
		System.out.println("-----");
		
		System.out.println(thAccounts);
		
		System.out.println("\n");
		
		// close the context
		context.close();

	}

}
