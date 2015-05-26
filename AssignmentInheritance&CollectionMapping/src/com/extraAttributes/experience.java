package com.extraAttributes;

public class experience implements Attributes{
	String name;
	int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	@Override
	public String toString() {
		return "experience [name=" + name + ", id=" + id + "]";
	}

	public experience() {
		super();
		// TODO Auto-generated constructor stub
	}

}
