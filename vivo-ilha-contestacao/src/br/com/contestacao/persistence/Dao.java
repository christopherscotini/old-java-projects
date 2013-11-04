package br.com.contestacao.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import br.com.contestacao.persistence.jpa.EntityPersistence;

public interface Dao {

	<T extends EntityPersistence> T save(T entity);

	<T extends EntityPersistence> void remove(T entity);

	<T extends EntityPersistence> List<T> findAll(Class<T> entityClass);

	<T extends EntityPersistence> List<T> findAll(CriteriaQuery<T> criteriaQuery);

	<T extends EntityPersistence> T find(CriteriaQuery<T> criteriaQuery);

	<T extends EntityPersistence, P extends Serializable> T findById(Class<T> entityClass, P primaryKey);

	CriteriaBuilder getCriteriaBuilder();

}