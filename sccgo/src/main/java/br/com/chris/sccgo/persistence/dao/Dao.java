package br.com.chris.sccgo.persistence.dao;

import java.io.Serializable;
import java.util.List;


public interface Dao<T, ID extends Serializable> {

	public	void insert(T entity);
	public	void update(T entity);
	public	void delete(ID primaryKey);
	public	List<T> findAll();
	public	T findById(ID primaryKey);
	
}
