package com.Student;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;


public class StudentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student s,s1;
		XmlBeanFactory beanFactory1 = new XmlBeanFactory(new ClassPathResource(
				"StudentXML.xml"));
		s= (Student) beanFactory1.getBean("s1");
		System.out.println(s);
		s1= (Student) beanFactory1.getBean("p1");
		System.out.println(s1);
	}

}
