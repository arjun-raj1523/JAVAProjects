package com.emp;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import Account.Account;


public class EmpTest {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp;
		XmlBeanFactory beanFactory1 = new XmlBeanFactory(new ClassPathResource(
				"Emp-Acc.xml"));
		XmlBeanFactory beanFactory2 = new XmlBeanFactory(new ClassPathResource(
				"byNameCall.xml"));
		XmlBeanFactory beanFactory3 = new XmlBeanFactory(new ClassPathResource(
				"byTypeCall.xml"));
		System.out.println("Direct Initalization:");
		emp= (Employee) beanFactory1.getBean("e1");
		System.out.println(emp);		     
		emp.withDraw(emp.acct);
		System.out.println("By NAME autowire:");
		emp = (Employee) beanFactory2.getBean("e2");
		System.out.println(emp);		     
		emp.withDraw(emp.acct);
		System.out.println("By Type autowire:");
		emp = (Employee) beanFactory3.getBean("e3");
		System.out.println(emp);		     
		emp.withDraw(emp.acct);
	}

}
