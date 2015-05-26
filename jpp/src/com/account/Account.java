package com.account;

public class Account {  
    private int accountNumber;  
    private String owner;  
    private double balance;  
        //no-arg and parameterized constructor  
        //getters and setters  
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public Account(int accountNumber, String owner, double balance) {
			super();
			this.accountNumber = accountNumber;
			this.owner = owner;
			this.balance = balance;
		}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
    
}