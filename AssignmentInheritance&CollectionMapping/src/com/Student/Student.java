package com.Student;

import java.util.Collection;
import java.util.Map;

import com.extraAttributes.Certification;

public class Student {
	String name;
	int id;
	Collection<Certification> certificate;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", certificate="
				+ certificate+"]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Collection<Certification> getCertificate() {
		return certificate;
	}
	public void setCertificate(Collection<Certification> certificate) {
		this.certificate = certificate;
	}
	
	

}
