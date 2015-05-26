package com.valueobjects;

public class CustomerVO {

	public String name;
	public String address;
	public String userId;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public CustomerVO() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CustomerVO [name=" + name + ", address=" + address
				+ ", userId=" + userId + "]";
	}
	

}
