package com.emp;

import Account.Account;

public class Employee {
	String Id,salary;
	Account acct;
	
	public Employee() {
		super();
	}
	
	public Account getAcct() {
		return acct;
	}

	public void setAcct(Account acct) {
		this.acct = acct;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public void withDraw(Account acct){
		
		System.out.println("Withdraw "+acct);
	}
	
	public String toString(){
		return Id+" "+salary+ " "+acct.withDraw();	
	}
}
