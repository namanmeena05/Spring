package com.rays.dao;

import java.util.List;

import com.rays.dto.UserDTO;

public interface UserDaoInt {
	
	public long add(UserDTO dto);

	public void update(UserDTO dto);
	
	public void delete(UserDTO dto);
	
	public List search(UserDTO dto);
	
	public UserDTO findByPk(long pk);
	
	public Integer nextPk(UserDTO dto);
	
	public UserDTO findByLogin(String login);
	
	public UserDTO authenticate(String login,String password);



}
