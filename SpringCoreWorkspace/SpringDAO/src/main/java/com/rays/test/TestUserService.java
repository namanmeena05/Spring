package com.rays.test;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.rays.dto.UserDTO;
import com.rays.service.UserServiceInt;

@Component("testUserService")
public class TestUserService {

	@Autowired
	public UserServiceInt service = null;

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");

		TestUserService test = (TestUserService) context.getBean("testUserService");

		// test.testAdd();
		// test.testUpdate();
		// test.testDelete();
		//test.testSearch();
		// test.testFindByPk();
		//test.testFindByLogin();
		//test.testAuthenticate();
		test.testSendMail();
	
	}

	

	private void testSendMail() {
	service.senMail();
	System.out.println("mail send");
		
	}



	private void testAuthenticate() {
	UserDTO dto = 	service.authenticate("sachin@gamail.com", "sachin@123");
	if(dto!=null) {
		System.out.println(dto.getFirstName());
		System.out.println(dto.getLastName());
		System.out.println(dto.getLogin());System.out.println(dto.getPassword());
	}
		
	}



	private void testFindByLogin() {
	UserDTO dto =	service.findByLogin("sachin@gamail.com");
	if(dto!=null) {
		System.out.println(dto.getFirstName());
	}
		
	}



	private void testSearch() {
		UserDTO dto = new UserDTO();
		List<UserDTO> list = service.search(dto);

		Iterator<UserDTO> it = list.iterator();
		while (it.hasNext()) {
			dto = (UserDTO) it.next();

			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getLogin());
			System.out.println(dto.getPassword());
		}

	}

	private void testFindByPk() {
		UserDTO dto = service.findByPk(1);

		if (dto != null) {
			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
		}

	}

	/*
	 * private void testSearch() { UserDTO dto = new UserDTO();
	 * 
	 * dto.getId(); service.search(dto);
	 * 
	 * System.out.println(dto.getFirstName());
	 * System.out.println(dto.getLastName()); System.out.println(dto.getLogin());
	 * System.out.println(dto.getPassword());
	 * 
	 * }
	 */
	private void testDelete() {
		UserDTO dto = new UserDTO();

		dto.setId(1);

		service.delete(dto);

		System.out.println("data delted");

	}

	private void testUpdate() {

		UserDTO dto = new UserDTO();

		dto.setFirstName("naman");
		dto.setId(1);

		service.update(dto);
		System.out.println("data updated");

	}

	private void testAdd() {

		UserDTO dto = new UserDTO();

		dto.setId(3);
		dto.setFirstName("ram");
		dto.setLastName("kalar");
		dto.setLogin("sachin@gamail.com");
		dto.setPassword("sachin@123");

		long pk = service.add(dto);

		System.out.println(pk);

	}

}
