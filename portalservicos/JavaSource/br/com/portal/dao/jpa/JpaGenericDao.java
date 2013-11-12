package br.com.portal.dao.jpa;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.transaction.annotation.Transactional;

import br.com.portal.dao.Dao;

public class JpaGenericDao<T, ID extends Serializable> implements Dao<T, ID> {

	@PersistenceContext(name="mkofficePU", type=PersistenceContextType.TRANSACTION)
	private EntityManager entityManager = null;

	@Transactional
	public T insert(T entity) {
		entityManager.persist(entity);
		entityManager.flush();
		return entity;
	}

	@Transactional
	public T update(T entity) {
		entityManager.merge(entity);
		entityManager.flush();
		return entity;
	}

	@Transactional
	public void delete(T entity) {
		entity = entityManager.merge(entity);
		entityManager.remove(entity);
	}
	
	@Transactional
	public T detachedToPersist(T entity) {
		return entityManager.merge(entity);
	}
	
	@Transactional
	public List<T> findAll() {
		CriteriaQuery<T> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(getGenericClass());
		criteriaQuery.from(getGenericClass());
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

	public T findById(ID primaryKey) {
		return entityManager.find(getGenericClass(), primaryKey);
	}

	@SuppressWarnings("unchecked")
	private Class<T> getGenericClass() {
		return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
