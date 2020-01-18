package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// read spring java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = 
				context.getBean("accountDAO", AccountDAO.class);
		
		// get membership bean from spring container
		MembershipDAO theMembershipDAO = 
				context.getBean("membershipDAO", MembershipDAO.class);
		
		// call the membership business method
		theMembershipDAO.addAccount();
		theMembershipDAO.goToSleep();
		
		// call the business method
		Account myAccount = new Account();
		theAccountDAO.addAccount(myAccount, true);	
		theAccountDAO.doWork();
			
		
		// close the context
		context.close();

	}

}
