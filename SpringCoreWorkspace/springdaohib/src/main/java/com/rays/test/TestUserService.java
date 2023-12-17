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

		test.testAdd();
		// test.testUpdate();
		// test.testDelete();
		// test.testSearch();
		// test.testFindByPk();
		// test.testFindByLogin();
		// test.testAuthenticate();

	}

	private void testFindByLogin() {
		UserDTO dto = new UserDTO();
		dto = service.findByLogin("sachin@gmail.com");

		System.out.println(dto.getFirstName());
		System.out.println("Data achieved....!!!");

	}

	private void testAuthenticate() {
		UserDTO dto = new UserDTO();

		service.authenticate("sachin@gmail.com", "123");

		System.out.println("User loggedin succesfully");

	}

	private void testSearch() {
		UserDTO dto = new UserDTO();
		dto.setFirstName("ram");
		List<UserDTO> list = service.search(dto);
		Iterator<UserDTO> it = list.iterator();

		while (it.hasNext()) {
			dto = it.next();

			System.out.println(dto.getId());

		}

	}

	private void testFindByPk() {
		UserDTO dto = new UserDTO();
		dto = service.findByPk(1);

		System.out.println(dto.getFirstName());
		System.out.println(dto.getLastName());

	}

	private void testDelete() {
		UserDTO dto = new UserDTO();
		dto.setId(3);

		service.delete(dto);
		System.out.println("data deleted successfully");

	}

	private void testUpdate() {
		UserDTO dto = new UserDTO();

		dto.setId(1);
		dto.setFirstName("ram");

		service.update(dto);

	}

	private void testAdd() {

		UserDTO dto = new UserDTO();

		dto.setFirstName("ghanshyyam");
		dto.setLastName("kalar");
		dto.setLogin("sachin@gmail.com");
		dto.setPassword("123");

		service.add(dto);
	}

}
