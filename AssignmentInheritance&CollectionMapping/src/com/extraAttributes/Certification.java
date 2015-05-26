package com.extraAttributes;

public class Certification implements Attributes {
	
	String name;

	public Certification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Certification [name=" + name + "]";
	}
	
	
}
