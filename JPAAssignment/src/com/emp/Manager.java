package com.emp;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Manager extends Emp implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4712442988242523383L;
	double salary;

	public double getSalary() {
		return salary;
	}

	public void setSalary(double d) {
		this.salary = d;
	}

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Manager [salary=" + salary + "]";
	}
	

}
