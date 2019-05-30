package br.com.soap.dao;

import java.util.List;

public interface IBaseDao <T, I> {
	T create (T t);
	T read(I i);
	List<T> readAll();
	T update(I i, T t);
	void delete(I i);
}
