package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint) {
	
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n =========>>>> Executing @After (finally) on method: "+ method);
		
	}
	
	@AfterThrowing(
				pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
				throwing = "theExc"
			)
	public void afterThrowingFindAccountsAdvice(
			JoinPoint theJoinPoint, Throwable theExc) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n =========>>>> Executing @AfterThrowing on method: "+ method);
		
		// log the exception
		System.out.println("\n =========>>>> The Exception is: "+ theExc);
		
	}
	
	
	@AfterReturning(
				pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
				returning = "result"
			)
	public void afterReturningAccountsAdvice(JoinPoint theJoinPoint, 
			List<Account> result) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n =========>>>> Executing @AfterReturning on method: "+ method);
		
		// print out the results of method call
		System.out.println("\n=========>>>> result is: "+ result);
		
		// let's post-process the data ... let's modify it
		
		// convert the account names to uppercase 
		convertAccountNamesToUpperCase(result);
		
		System.out.println("\n============>>>> result is: "+ result);
		
		
	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {

		// loop through accounts
		
		for(Account tempAccount : result) {
			
			// get uppercase version of name
			String theUpperName = tempAccount.getName().toUpperCase();
			
			// update the name on the account
			tempAccount.setName(theUpperName);			
		}
		
		
	}

	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		
		System.out.println("\n ======>>>> Executing @Before advice on method");
		
		// display the method signature
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method: "+ methodSignature);
		
		// display method arguments
		
		
		// get args
		Object[] args = theJoinPoint.getArgs();
		
		// loop through args
		for(Object tempArg : args) {
			System.out.println(tempArg);
			
			if(tempArg instanceof Account) {
				
				// downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;
				
				System.out.println("Calling Mtehod from Account (getName): "+  theAccount.getName());
				System.out.println("Calling Mtehod from Account (getLevel): "+ theAccount.getLevel());
			}
		}
		
		
		
	}
	

}
