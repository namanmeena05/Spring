package com.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.rays.dao.UserDAOHibImpl;
import com.rays.dto.UserDTO;

@Service
public class UserServiceImpl{

	@Autowired
	private UserDAOHibImpl dao;

	@Transactional(propagation = Propagation.REQUIRED)
	public long add(UserDTO dto) {
		long pk = dao.add(dto);

		return pk;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(UserDTO dto) {
		dao.update(dto);

	}

	 @Transactional
	public void delete(UserDTO dto) {
		dao.delete(dto);

	}

	@Transactional
	public UserDTO findByPk(long pk) {
		UserDTO dto = dao.findByPk(pk);
		return dto;
	}

	@Transactional
	public List search(UserDTO dto , int pageNo , int  pageSize) {
		return dao.search(dto , pageNo , pageSize);

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public UserDTO authenticate(String login, String password) {
		return dao.authenticate(login, password);

	}

	 @Transactional
	public UserDTO findByLogin(String login) {
		return dao.findByLogin(login);

	}

	/*
	 * public List search(UserDTO dto) { dao.search(dto); return null; }
	 */

}
