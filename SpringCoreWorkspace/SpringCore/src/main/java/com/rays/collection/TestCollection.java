package com.rays.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCollection {
	
	public static void main(String[] args) {
		
		ApplicationContext context  = new ClassPathXmlApplicationContext("Collection.xml");
		
	MyBean bean	 = (MyBean) context.getBean("myBean");
	
	bean.display();
		
	}

}
