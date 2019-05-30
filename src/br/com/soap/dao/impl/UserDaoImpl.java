package br.com.soap.dao.impl;

import java.util.List;

import javax.ejb.Stateless;

import br.com.soap.dao.IUserDao;
import br.com.soap.model.User;

@Stateless
public class UserDaoImpl extends BaseDao<User, Long> implements IUserDao {

	@Override
	public User create(User t) {
		entityManager.persist(t);
		return t;
	}

	@Override
	public User read(Long i) {
		return entityManager.find(User.class, i);
	}

	@Override
	public List<User> readAll() {
		return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
	}

	@Override
	public User update(Long i, User t) {
		return null;
	}

	@Override
	public void delete(Long i) {
	}

}
