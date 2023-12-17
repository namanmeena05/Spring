package com.rays.service;

import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.UserDaoInt;
import com.rays.dto.UserDTO;

@Service
public class UserServiceImpl implements UserServiceInt {
	
	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private UserDaoInt dao = null;

	//@Transactional(propagation = Propagation.REQUIRED)
	public long add(UserDTO dto) {
		long pk = dao.add(dto);

		return pk;
	}

	//@Transactional(propagation = Propagation.REQUIRED)
	public void update(UserDTO dto) {
		dao.update(dto);

	}

	public void delete(UserDTO dto) {
		dao.delete(dto);

	}

	public Integer nextPk(UserDTO dto) {
		int pk = dao.nextPk(dto);
		return pk + 1;
	}

	@Transactional
	public UserDTO findByPk(long pk) {
		return dao.findByPk(pk);

	}

	public List search(UserDTO dto) {
		List list = dao.search(dto);
		return list;
	}

	public UserDTO findByLogin(String login) {
	 return dao.findByLogin(login);
		
	}

	public UserDTO authenticate(String login, String password) {
		return dao.authenticate(login, password);
		
	}

	public void senMail() {
		MimeMessage msg = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(msg,true);
			helper.setTo("factology79@gmail.com");
			helper.setSubject("Test Subject");
			helper.setText("sachin kalar",true);
			
			mailSender.send(msg);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	

}
