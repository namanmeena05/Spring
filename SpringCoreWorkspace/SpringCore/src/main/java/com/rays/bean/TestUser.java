package com.rays.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class TestUser {
	
	public static void main(String[] args) {
		
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("userconfig.xml"));
		
	User bean =	(User) factory.getBean("user");
	
	System.out.println(bean.getLogin());
	System.out.println(bean.getPassword());
	}

}
