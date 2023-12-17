package com.rays.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class TestPerson {
	
	public static void main(String[] args) {
		
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("com/rays/bean/personconfig.xml"));
		
	Person person	= (Person) factory.getBean("person");
	
	System.out.println(person.getId());
	System.out.println(person.getName());
	System.out.println(person.getSalary());
	}

}
