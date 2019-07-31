package br.com.soap.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.soap.dao.IBaseDao;

@Stateless
public abstract class BaseDao<T, I> implements IBaseDao<T, I> {

	@PersistenceContext(unitName="default-PU")
	protected EntityManager entityManager;
	
	public BaseDao() {
	}
}
