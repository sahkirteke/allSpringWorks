package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addAccount() {
		
		System.out.println(getClass() + " : membership Class adding");
	}
	
	public void goToSleep() {
		System.out.println(getClass() + "SLEEP SLEP SLeep");
	}
	
}
