package br.com.utmanager.persistence;

import java.io.Serializable;
import java.util.List;

/**
 *  @param <T> the entity type
 * @param <ID> the primary key type
 
 */

public interface Dao<T, ID extends Serializable> {

	T insert(T entity);
	
	void saveAll(List<T> entities);

	T update(T entity);

	void delete(T entity);

	List<T> findAll();

	T findById(ID primaryKey);
	
}
