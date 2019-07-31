package br.com.soap.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.soap.dao.IUserDao;
import br.com.soap.model.User;
import br.com.soap.services.IUserService;

@Stateless
public class UserServiceImpl implements IUserService {
	
	@Inject
	private IUserDao dao;

	@Override
	public User create(User t) {
		System.out.println(t);
		return dao.create(t);
	}

	@Override
	public User read(Long id) {
		return dao.read(id);
	}

	@Override
	public List<User> readAll() {
		System.out.println("readAll");
		return dao.readAll();
	}

	@Override
	public void delete(Long id) {
		System.out.println("delete");
		dao.delete(id);
	}

	@Override
	public User update(Long i, User t) {
		System.out.println("update");
		return dao.update(i, t);
	}
}
