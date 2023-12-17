package com.rays.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMultiple {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("multiple.xml");
		
		User bean  = (User) context.getBean("user");
		
	Person per	= (Person) context.getBean("person");
	
	System.out.println(bean.getLogin());
	System.out.println(per.getId());
	}

}
