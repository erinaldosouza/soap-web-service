package br.com.soap.services;

import java.util.List;

public interface IBaseService<T, I> {
	T create (T t);
	T read(I i);
	List<T> readAll();
	T update(I i, T t);
	void delete(I i);
}
