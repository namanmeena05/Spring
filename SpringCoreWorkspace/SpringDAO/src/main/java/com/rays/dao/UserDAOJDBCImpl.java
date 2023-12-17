package com.rays.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rays.dto.UserDTO;

@Repository
public class UserDAOJDBCImpl implements UserDaoInt {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public long add(UserDTO dto) {
		String sql = "insert into user values(?,?,?,?,?)";
		System.out.println(dto.getId());
		System.out.println(dto.getFirstName());
		System.out.println(dto.getLastName());
		System.out.println(dto.getLogin());
		System.out.println(dto.getPassword());
		int pk = jdbcTemplate.update(sql, dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getLogin(),
				dto.getPassword());
		return pk;
	}

	public void update(UserDTO dto) {
		String sql = "update user set FIRST_NAME=?, LAST_NAME=?, LOGIN_ID=?, PASSWORD=? where ID=?";

		int i = jdbcTemplate.update(sql, dto.getId());

	}

	public void delete(UserDTO dto) {
		String sql = "delete from user where ID=?";
		jdbcTemplate.update(sql, dto.getId());
	}

	public Integer nextPk(UserDTO dto) {
		String sql = "select max(ID) from user";

		int pk = jdbcTemplate.update(sql, dto.getFirstName(), dto.getLastName(), dto.getLogin(), dto.getPassword(),
				dto.getId());

		return pk++;
	}

	public UserDTO findByPk(long pk) {

		String sql = "SELECT ID,FIRST_NAME,LAST_NAME,LOGIN_ID,PASSWORD FROM USER WHERE ID=?";
		Object[] params = { pk };

		List list = jdbcTemplate.query(sql, params, new UserMapper());

		UserDTO dto = null;
		if (list.size() > 0) {
			dto = (UserDTO) list.get(0);
		}
		return dto;

	}

	public List search(UserDTO dto) {
		String sql = "select * from user ";
		List list = jdbcTemplate.query(sql, new UserMapper());

		return list;
	}

	public UserDTO findByLogin(String login) {
		String sql = "select * from user where login_id=?";
		Object[] params = {login};
		List list =  jdbcTemplate.query(sql, params,new UserMapper());
		UserDTO dto = null;
		if(list.size() > 0) {
		dto =	(UserDTO) list.get(0);
		}
		return dto;
	}

	public UserDTO authenticate(String login, String password) {
		
		String sql = "select * from user where login_id=? and password=?";
		Object[] params = {login,password};
  UserDTO dto =	(UserDTO) jdbcTemplate.queryForObject(sql,params, new UserMapper());
	 
			return dto;
	}

	

}
