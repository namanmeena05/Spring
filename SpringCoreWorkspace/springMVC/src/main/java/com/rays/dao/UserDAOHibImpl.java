package com.rays.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dto.UserDTO;

@Repository
public class UserDAOHibImpl {

	@Autowired
	private org.hibernate.SessionFactory sessionFactory = null;

	@Transactional
	public long add(UserDTO dto) {
		UserDTO ExistDto = findByLogin(dto.getLogin());
		if (ExistDto != null) {

		}
		long pk = (Long) sessionFactory.getCurrentSession().save(dto);
		return pk;
	}

	public void update(UserDTO dto) {
		sessionFactory.getCurrentSession().saveOrUpdate(dto);

	}

	public void delete(UserDTO dto) {
		sessionFactory.getCurrentSession().delete(dto);

	}

	public UserDTO findByPk(long pk) {
		UserDTO dto = sessionFactory.getCurrentSession().get(UserDTO.class, pk);
		return dto;
	}

	public List search(UserDTO dto, int pageNo, int pageSize) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserDTO.class);
		if (dto != null) {
			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				criteria.add(Restrictions.like("firstName", dto.getFirstName()));

			}

			if (dto.getUserId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getUserId()));
			}
		}
		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			criteria.setFirstResult(pageNo);
			criteria.setMaxResults(pageSize);
		}

		List list = criteria.list();

		System.out.println(list);

		return list;
	}

	public UserDTO authenticate(String login, String password) {
		Query q = sessionFactory.getCurrentSession().createQuery("FROM UserDTO WHERE LOGIN=? AND PASSWORD=?");
		q.setString(0, login);
		q.setString(1, password);
		List list = q.list();
		UserDTO dto = null;
		if (list.size() > 0) {
			dto = (UserDTO) list.get(0);
		}

		return dto;
	}

	public UserDTO findByLogin(String login) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserDTO.class);
		criteria.add(Restrictions.eq("login", login));
		List list = criteria.list();
		UserDTO dto = null;
		if (list.size() > 0) {
			dto = (UserDTO) list.get(0);
		}

		return dto;
	}

}
