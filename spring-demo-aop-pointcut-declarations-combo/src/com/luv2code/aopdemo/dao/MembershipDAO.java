package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public boolean addAccount() {
		
		System.out.println(getClass() + ": DOING SOME STUFF: ADDING A MEMBERSHIP ACCOUNT");		
		
		return true;
	}
	
	public void goToSleep() {
		
		System.out.println(getClass() + ": gotoSleep");
	}

}
