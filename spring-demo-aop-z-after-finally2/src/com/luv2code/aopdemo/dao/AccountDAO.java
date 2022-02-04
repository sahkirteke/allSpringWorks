package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	private String name;
	private String serviceCode;

	public void addAccount(Account theAccount , boolean vipFlag) {
		
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
		
	}
	
	public boolean doWork() {
		System.out.println(getClass() + "work wokr work");
		return false;
	}

	public String getName() {
		System.out.println(getClass() + ": in GetNAme()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ":in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": in getServiceCOde");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in setServiceCode()");
		this.serviceCode = serviceCode;
	}
	
	public  List<Account> findAccounts(boolean tripWire) {
		
		if(tripWire) {
			throw new RuntimeException("No Soup For YOu");
		}
	
		List<Account> myAccounts = new ArrayList<Account>();
		
		Account temp1 = new Account("husam","silver");
		Account temp2 = new Account("asya","gold");
		Account temp3 = new Account("asyse","bronze");
		
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		
		
		
		return myAccounts;
}
}