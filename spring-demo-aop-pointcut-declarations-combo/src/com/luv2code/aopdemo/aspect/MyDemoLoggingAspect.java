package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// this is where we add all of our related advices for logging
	
	// let's start with an @Before advice
	
	// @Before("execution(public void addAccount())")
	
	// @Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
	
	// @Before("execution(public void add*())")
	
	// @Before("execution(void add*())")
	
	// @Before("execution(* add*(com.luv2code.aopdemo.Account))")
	
	//@Before("execution(* add*(com.luv2code.aopdemo.Account, ..))")
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDaoPackage( ) {}
	
	// create point cut for getter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	// create pointcut to setter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	// create point: include package .. exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n ======>>>> Executing @Before advice on method");
		
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		
		System.out.println("\n ======>>>> Performing API analytics");
		
	}
	
	

}
